package com.project.Models.Images;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ImageJDBCAccessService implements ImageDAO{
    private JdbcTemplate jdbcTemplate;
    private ImageRowMapper rowMapper;

    public ImageJDBCAccessService(JdbcTemplate jdbcTemplate, ImageRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Images> selectAllImages(Integer user_id){
        String sql = "SELECT image_id, image_url FROM images WHERE user_id = " + user_id;

        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void addImage(Images image){
        String sql = "INSERT INTO images(image_url, user_id) VALUES(?, ?)";

        jdbcTemplate.update(sql, image.getImageUrl(), image.getUser_id().getId());
    }

    @Override
    public void removeImage(String fileUrl){
        String sql = "DELETE FROM images WHERE image_url = ?";

        jdbcTemplate.update(sql, fileUrl);
    }
}
