package com.webProject.codeAcademy.repositories;

import com.webProject.codeAcademy.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepositories extends JpaRepository<Comment,Long> {
    List<Comment> findByUserIdAndVideoId(Long userId, Long videoId);

    List<Comment> findByUserId(Long userId);

    List<Comment> findByVideoId(Long videoId);

}
