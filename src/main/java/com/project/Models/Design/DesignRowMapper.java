package com.project.Models.Design;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DesignRowMapper implements RowMapper<Design> {
    @Override
    public Design mapRow(ResultSet rs, int rowNum) throws SQLException {

        Design design = new Design();

        design.setDesign_id(rs.getInt("design_id"));
        design.setDesign(rs.getString("design"));

        return design;
    }
}
