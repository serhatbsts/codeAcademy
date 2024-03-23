package com.webProject.codeAcademy.repositories;

import com.webProject.codeAcademy.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepositories extends JpaRepository<Video,Long> {
    List<Video> findByUserId(Long userId);
}
