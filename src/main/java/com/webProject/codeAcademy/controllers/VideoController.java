package com.webProject.codeAcademy.controllers;

import com.webProject.codeAcademy.entities.Video;
import com.webProject.codeAcademy.services.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {
    VideoService videoService;

    @GetMapping
    public List<Video> getAllVideos(@RequestParam Optional<Long> userId){
        return videoService.getAllVideos(userId);
    }

    @PostMapping
    public Video createOneVideo(@RequestBody Video newVideo){

        return videoService.createOneVideo(newVideo);
    }
    @GetMapping("/{videoId}")
    public Video getOneVideo(@PathVariable Long videoId){
        return videoService.getOneVideoById(videoId);
    }

}
