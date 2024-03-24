package com.webProject.codeAcademy.services;

import com.webProject.codeAcademy.entities.Comment;
import com.webProject.codeAcademy.entities.User;
import com.webProject.codeAcademy.entities.Video;
import com.webProject.codeAcademy.repositories.CommentRepositories;
import com.webProject.codeAcademy.request.CommentCreateRequest;
import com.webProject.codeAcademy.request.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepositories commentRepositories;
    @Autowired
    UserService userService;
    @Autowired
    VideoService videoService;

    public CommentService(CommentRepositories commentRepositories, UserService userService, VideoService videoService) {
        this.commentRepositories = commentRepositories;
        this.userService = userService;
        this.videoService = videoService;
    }

    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> videoId) {
        if (userId.isPresent() && videoId.isPresent()) {
            return commentRepositories.findByUserIdAndVideoId(userId.get(), videoId.get());
        } else if (userId.isPresent()) {
            return commentRepositories.findByUserId(userId.get());
        } else if (videoId.isPresent()) {
            return commentRepositories.findByVideoId(videoId.get());
        } else {
            return commentRepositories.findAll();

        }

    }

    public Comment getOneComment(Long commentId) {
        return commentRepositories.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUser(commentCreateRequest.getUserId());
        Video video = videoService.getOneVideoById(commentCreateRequest.getVideoId());
        if (user != null && video != null) {
            Comment toSave = new Comment();
            toSave.setId(commentCreateRequest.getId());
            toSave.setVideo(video);
            toSave.setUser(user);
            toSave.setText(commentCreateRequest.getText());
            return commentRepositories.save(toSave);
        } else {
            return null;
        }
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepositories.findById(commentId);
        if (comment.isPresent()) {
            Comment toUpdate = comment.get();
            toUpdate.setText(commentUpdateRequest.getText());
            return commentRepositories.save(toUpdate);

        } else {
            return null;
        }
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepositories.deleteById(commentId);
    }
}
