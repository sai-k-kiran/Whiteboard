package com.project.Models.User;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDAO userDAO;

    public UserDetailsServiceImpl(@Qualifier("jdbc") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.selectUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with " + username + " not found"));
    }
}
