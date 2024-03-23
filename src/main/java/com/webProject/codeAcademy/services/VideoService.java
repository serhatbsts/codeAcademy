package com.webProject.codeAcademy.services;

import com.webProject.codeAcademy.entities.Video;
import com.webProject.codeAcademy.repositories.VideoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
        VideoRepositories videoRepositories;

    public VideoService(VideoRepositories videoRepositories) {
        this.videoRepositories = videoRepositories;
    }

    public List<Video> getAllVideos(Optional<Long> userId) {
        if (userId.isPresent()){
            return videoRepositories.findByUserId(userId.get());
        }else {
            return videoRepositories.findAll();
        }
    }

    public Video getOneVideoById(Long videoId) {
        //custom exeption ekle
        return videoRepositories.findById(videoId).orElse(null);
    }


    public Video createOneVideo(Video newVideo) {

        return videoRepositories.save(newVideo);
    }
}
