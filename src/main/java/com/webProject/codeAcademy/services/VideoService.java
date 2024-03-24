package com.webProject.codeAcademy.services;

import com.webProject.codeAcademy.entities.User;
import com.webProject.codeAcademy.entities.Video;
import com.webProject.codeAcademy.repositories.VideoRepositories;
import com.webProject.codeAcademy.request.VideoCreateRequest;
import com.webProject.codeAcademy.request.VideoUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    VideoRepositories videoRepositories;
    @Autowired
    UserService userService;

    public VideoService(VideoRepositories videoRepositories,UserService userService) {
        this.videoRepositories = videoRepositories;
        this.userService=userService;
    }

    public List<Video> getAllVideos(Optional<Long> userId) {
        if (userId.isPresent()) {
            return videoRepositories.findByUserId(userId.get());
        } else {
            return videoRepositories.findAll();
        }
    }

    public Video getOneVideoById(Long videoId) {
        //custom exeption ekle
        return videoRepositories.findById(videoId).orElse(null);
    }


    public Video createOneVideo(VideoCreateRequest newVideo) {
        User user=userService.getOneUser(newVideo.getUserId());
        if (user==null)
            return null;
        Video toSave=new Video();
        toSave.setId(newVideo.getId());
        toSave.setText(newVideo.getText());
        toSave.setTitle(newVideo.getTitle());
        toSave.setUser(user);
        return videoRepositories.save(toSave);
    }

    public Video updateOneVideoById(Long videoId, VideoUpdateRequest videoUpdateRequest) {
        Optional<Video> video=videoRepositories.findById(videoId);
        if (video.isPresent()){
            Video toUpdate=video.get();
            toUpdate.setText(videoUpdateRequest.getText());
            toUpdate.setTitle(videoUpdateRequest.getTitle());
            videoRepositories.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOneVideoById(Long videoId) {
        videoRepositories.deleteById(videoId);
    }
}
