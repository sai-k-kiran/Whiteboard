package com.project.Models.Images;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ImageRowMapper implements RowMapper<Images> {
    @Override
    public Images mapRow(ResultSet rs, int rowNum) throws SQLException {
        Images image = new Images();

        image.setImageUrl(rs.getString("image_url"));
        image.setId(rs.getInt("image_id"));

        return image;
    }
}
