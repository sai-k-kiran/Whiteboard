package com.project.Models.Design;

import com.project.Models.User.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("design-jdbc")
public class DesignJDBCAccessService implements DesignDAO{
    private JdbcTemplate jdbcTemplate;
    private DesignRowMapper rowMapper;

    public DesignJDBCAccessService(JdbcTemplate jdbcTemplate, DesignRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Design> selectDesignsOfUser(Integer id){
        String sql = "SELECT design_id, design FROM designs WHERE user_id = " + id;

        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void addDesign(Design request){
        String sql = "INSERT INTO designs(design, user_id) VALUES(?, ?)";

        User user = request.getUser_id();

        jdbcTemplate.update(sql,
                request.getDesign(),
                user.getId());
    }

    @Override
    public void deleteDesign(Integer design_id){
        String sql = "DELETE FROM designs where design_id = ?";

        jdbcTemplate.update(sql, design_id);
    }
}
