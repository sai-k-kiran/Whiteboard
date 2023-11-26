package com.project.Repository;

import com.project.Models.Images.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images, Integer> {
}
