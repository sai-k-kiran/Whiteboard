package com.project.Models.Design;

import com.project.Models.User.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("design-jdbc")
public class DesignJDBCAccessService implements DesignDAO{
    private JdbcTemplate jdbcTemplate;
    private DesignRowMapper rowMapper;

    public DesignJDBCAccessService(JdbcTemplate jdbcTemplate, DesignRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Design> selectAllDesigns(){
        var sql = """
                Select design_id, design, user_id from designs;
                """;

        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Design> selectDesignById(Integer id){
        var sql = """
                 Select design_id, design, user_id from designs where id = ?;
                 """;
        return jdbcTemplate.query(sql, rowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void addDesign(Design request){
        String sql = "INSERT INTO designs(design, user_id) VALUES(?, ?)";

        User user = request.getUser_id();
        System.out.println(user.getId()+ " " + user.getName());

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
