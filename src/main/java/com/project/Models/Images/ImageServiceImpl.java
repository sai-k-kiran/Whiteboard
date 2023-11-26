package com.project.Models.Images;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService{
    private ImageDAO imageDAO;
    private ImageDTOMapper dtoMapper;

    public ImageServiceImpl(ImageDAO imageDAO, ImageDTOMapper dtoMapper) {
        this.imageDAO = imageDAO;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<ImageDTO> getAllImages(Integer user_id){
        return imageDAO.selectAllImages(user_id)
                .stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public void uploadImage(ImageUploadRequest request){
        imageDAO.addImage(new Images(request.imageUrl(), request.user()));
    }

    @Override
    public void deleteImage(String url){
        imageDAO.removeImage(url);
    }
}
