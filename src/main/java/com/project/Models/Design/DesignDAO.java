package com.project.Models.Design;

import com.project.Models.User.User;

import java.util.List;
import java.util.Optional;

public interface DesignDAO {
    public List<Design> selectAllDesigns();
    public Optional<Design> selectDesignById(Integer id);
    public void addDesign(Design request);
    public void deleteDesign(Integer id);
}
