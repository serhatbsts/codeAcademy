package com.webProject.codeAcademy.repositories;

import com.webProject.codeAcademy.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepositories extends JpaRepository<Video,Long> {
}
