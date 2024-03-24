package com.webProject.codeAcademy.repositories;

import com.webProject.codeAcademy.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepositories extends JpaRepository<Like,Long> {
    List<Like> findByUserIdAndVideoId(Long userId, Long videoId);

    List<Like> findByUserId(Long userId);

    List<Like> findByVideoId(Long videoId);
}
