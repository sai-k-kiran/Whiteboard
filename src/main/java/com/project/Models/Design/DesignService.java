package com.project.Models.Design;


import com.project.Models.User.User;

import java.util.List;

public interface DesignService {
    public List<DesignDTO> getAllDesigns(Integer id);
    public void addDesign(DesignCreationRequest request);
    public void removeDesign(Integer id);
}
