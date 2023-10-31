package com.project.Models.Design;

import com.project.Models.User.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DesignRowMapper implements RowMapper<Design> {
    @Override
    public Design mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Design(
                rs.getInt("designId"),
                rs.getString("design"),
                rs.getObject("userId", User.class)
        );
    }
}
