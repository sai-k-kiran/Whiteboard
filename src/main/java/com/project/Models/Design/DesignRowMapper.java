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
                rs.getInt("design_id"),
                rs.getString("design"),
                rs.getObject("user_id", User.class)
        );
    }
}
