package com.project.Models.Images;

import java.util.List;

public interface ImageDAO {
    public List<Images> selectAllImages(Integer id);
    public void addImage(Images request);
    public void removeImage(String url);
}
