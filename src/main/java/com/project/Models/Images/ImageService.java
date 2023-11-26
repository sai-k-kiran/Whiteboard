package com.project.Models.Images;

import java.util.List;

public interface ImageService {
    public List<ImageDTO> getAllImages(Integer id);
    public void uploadImage(ImageUploadRequest request);
    public void deleteImage(String url);
}
