package com.project.Models.Images;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ImageDTOMapper implements Function<Images, ImageDTO> {
    @Override
    public ImageDTO apply(Images image){
        return new ImageDTO(
                image.getId(),
                image.getImageUrl()
        );
    }
}
