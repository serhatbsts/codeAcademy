package com.webProject.codeAcademy.repositories;

import com.webProject.codeAcademy.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositories extends JpaRepository<Comment,Long> {
}
