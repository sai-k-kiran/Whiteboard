package com.project.Models.Design;

import com.project.Exception.ResourceNotFound;
import com.project.Models.User.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesignServiceImpl implements DesignService{
    private final DesignDAO designDAO;
    private final DesignDTOMapper dtoMapper;

    public DesignServiceImpl(@Qualifier("design-jdbc") DesignDAO designDAO, DesignDTOMapper dtoMapper) {
        this.designDAO = designDAO;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<DesignDTO> getAllDesigns(Integer id){
        return designDAO.selectDesignsOfUser(id)
                .stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public void addDesign(DesignCreationRequest request){
        designDAO.addDesign(new Design(request.design(), request.user()));
    }

    @Override
    public void removeDesign(Integer id){
        designDAO.deleteDesign(id);
    }

}
