package com.webProject.codeAcademy.services;

import com.webProject.codeAcademy.entities.Like;
import com.webProject.codeAcademy.entities.User;
import com.webProject.codeAcademy.entities.Video;
import com.webProject.codeAcademy.repositories.LikeRepositories;
import com.webProject.codeAcademy.request.LikeCreateRequest;
import com.webProject.codeAcademy.responses.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeServices {
    @Autowired
    LikeRepositories likeRepositories;
    @Autowired
    UserService userService;
    @Autowired
    VideoService videoService;

    public LikeServices(LikeRepositories likeRepositories, UserService userService, VideoService videoService) {
        this.likeRepositories = likeRepositories;
        this.userService = userService;
        this.videoService = videoService;
    }

    public void deleteOneLikeById(Long likeId) {
        likeRepositories.deleteById(likeId);
    }

    public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> videoId) {
        List<Like> list;
        if(userId.isPresent() && videoId.isPresent()) {
            list = likeRepositories.findByUserIdAndVideoId(userId.get(), videoId.get());
        }else if(userId.isPresent()) {
            list = likeRepositories.findByUserId(userId.get());
        }else if(videoId.isPresent()) {
            list = likeRepositories.findByVideoId(videoId.get());
        }else
            list = likeRepositories.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }

    public Like getOneLikeById(Long LikeId) {
        return likeRepositories.findById(LikeId).orElse(null);
    }

    public Like createOneLike(LikeCreateRequest request) {
        User user = userService.getOneUser(request.getUserId());
        Video video = videoService.getOneVideoById(request.getVideoId());
        if(user != null && video != null) {
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setVideo(video);
            likeToSave.setUser(user);
            return likeRepositories.save(likeToSave);
        }else
            return null;
    }
}
