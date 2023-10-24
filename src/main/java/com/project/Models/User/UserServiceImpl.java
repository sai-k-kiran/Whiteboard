package com.project.Models.User;

import com.project.Exception.DuplicateResource;
import com.project.Exception.ResourceNotFound;
import com.project.Exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    private final UserDTOMapper userDTOMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(@Qualifier("jdbc") UserDAO userDAO,
                           UserDTOMapper userDTOMapper, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.userDTOMapper = userDTOMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getAllUsers(){
        return userDAO.selectAllUsers()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id){
        return userDAO.selectUserById(id)
                .map(userDTOMapper)
                .orElseThrow(() -> new ResourceNotFound("Customer with [%s] not found".formatted(id)));
    }

    @Override
    public void addUser(UserRegistrationRequest request){
        if(userDAO.emailExists(request.email())){
            throw new DuplicateResource("Customer with %s already exists".formatted(request.email()));
        }

        userDAO.registerUser(new User(
                request.name(),
                request.email(),
                request.companyName(),
                request.phoneNum(),
                request.location(),
                passwordEncoder.encode(request.password()))
        );
    }

    @Override
    public void removeUser(Integer id) {
        if(!userDAO.idExists(id)){
            throw new ResourceNotFound("User with %s not found".formatted(id));
        }

        userDAO.deleteUserById(id);
    }

    @Override
    public void updateUser(Integer id, UserUpdateRequest request){
        User u = userDAO.selectUserById(id)
                .orElseThrow(() -> new ResourceNotFound("User with %s not found".formatted(id)));

        boolean changes = false;
        if(request.name() != null && request.name().length() != 0 &&
                        !request.name().equals(u.getName())){
            u.setName(request.name());
            changes = true;
        }

        if(request.companyName() != null && request.companyName().length() != 0 &&
                !request.companyName().equals(u.getCompanyName())){
            u.setCompanyName(request.companyName());
            changes = true;
        }

        if(request.phoneNum() != null && request.phoneNum().length() != 0 &&
                !request.phoneNum().equals(u.getPhoneNum())){
            u.setPhoneNum(request.phoneNum());
            changes = true;
        }

        if(request.location() != null && request.location().length() != 0 &&
                !request.location().equals(u.getLocation())){
            u.setLocation(request.location());
            changes = true;
        }

        if(!changes) throw new ResourceValidationException("No changes found");
        userDAO.updateUser(u);
    }
}
