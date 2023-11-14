package com.project.Models.Design;

import java.util.List;

public interface DesignService {
    public List<DesignDTO> getAllDesigns(Integer id);
    public void addDesign(DesignCreationRequest request);
    public void removeDesign(Integer id);
}
