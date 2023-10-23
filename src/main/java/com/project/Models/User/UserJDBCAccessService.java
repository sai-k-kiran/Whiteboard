package com.project.Models.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class UserJDBCAccessService implements UserDAO {
    private UserRowMapper userRowMapper;
    private JdbcTemplate jdbcTemplate;

    public UserJDBCAccessService(UserRowMapper userRowMapper, JdbcTemplate jdbcTemplate) {
        this.userRowMapper = userRowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> selectAllUsers() {
        var sql = """
                Select id, name, email, company_name, phone_num, location, password from users
                """;

        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public Optional<User> selectUserById(Integer id){
        var sql = """
                 Select id, name, email, company_name, phone_num, location, password from users where id = ?;
                 """;
        return jdbcTemplate.query(sql, userRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void registerUser(User request){
        String sql = "INSERT INTO users(name, email, company_name, phone_num, location, password) VALUES(?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                request.getName(),
                request.getEmail(),
                request.getCompanyName(),
                request.getPhoneNum(),
                request.getLocation(),
                request.getPassword());
    }
    @Override
    public void deleteUserById(Integer id){
        String sql = "DELETE FROM users where id = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateUser(User request){
        if(request.getName() != null){
            String sql = "UPDATE users SET name = ? WHERE id = ?";

            int result = jdbcTemplate.update(
                    sql,
                    request.getName(),
                    request.getId()
            );
        }
        if(request.getCompanyName() != null){
            String sql = "UPDATE users SET company_name = ? WHERE id = ?";

            int result = jdbcTemplate.update(
                    sql,
                    request.getCompanyName(),
                    request.getId()
            );
        }

        if(request.getPhoneNum() != null){
            String sql = "UPDATE users SET phone_num = ? WHERE id = ?";

            int result = jdbcTemplate.update(
                    sql,
                    request.getPhoneNum(),
                    request.getId()
            );
        }
        if(request.getLocation() != null){
            String sql = "UPDATE users SET location = ? WHERE id = ?";

            int result = jdbcTemplate.update(
                    sql,
                    request.getLocation(),
                    request.getId()
            );
        }
    }

    @Override
    public boolean emailExists(String email){
        String sql = "SELECT COUNT(*) FROM users where email = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return (count != null && count > 0);
    }

    @Override
    public boolean idExists(Integer id) {
        String sql = "Select count(id) from users where id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return (count != null && count > 0);
    }

    @Override
    public Optional<User> selectUserByEmail(String email) {
        String sql = "SELECT id, name, email, company_name, phone_num, location FROM users WHERE email = ?";
        return jdbcTemplate.query(sql, userRowMapper, email)
                .stream()
                .findFirst();
    }
}
