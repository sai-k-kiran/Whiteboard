package com.project.Models.Design;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DesignDTOMapper implements Function<Design, DesignDTO> {
    @Override
    public DesignDTO apply(Design design){
        return new DesignDTO(
                design.getDesignId(),
                design.getDesign(),
                design.getUserId()
        );
    }
}
