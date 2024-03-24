package com.webProject.codeAcademy.controllers;

import com.webProject.codeAcademy.entities.Video;
import com.webProject.codeAcademy.request.VideoCreateRequest;
import com.webProject.codeAcademy.request.VideoUpdateRequest;
import com.webProject.codeAcademy.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping
    public List<Video> getAllVideos(@RequestParam Optional<Long> userId){
        return videoService.getAllVideos(userId);
    }

    @PostMapping
    public Video createOneVideo(@RequestBody VideoCreateRequest newVideo){

        return videoService.createOneVideo(newVideo);
    }
    @GetMapping("/{videoId}")
    public Video getOneVideo(@PathVariable Long videoId){
        return videoService.getOneVideoById(videoId);
    }
    @PutMapping("/{videoId}")
    public Video updateOneVideo(@PathVariable Long videoId, @RequestBody VideoUpdateRequest videoUpdateRequest){
        return videoService.updateOneVideoById(videoId,videoUpdateRequest);
    }
    @DeleteMapping("/{videoId}")
    public void deleteOneVideo(@PathVariable Long videoId){
        videoService.deleteOneVideoById(videoId);
    }

}
