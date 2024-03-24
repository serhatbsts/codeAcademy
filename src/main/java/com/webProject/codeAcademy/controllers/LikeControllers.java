package com.webProject.codeAcademy.controllers;

import com.webProject.codeAcademy.entities.Like;
import com.webProject.codeAcademy.request.LikeCreateRequest;
import com.webProject.codeAcademy.responses.LikeResponse;
import com.webProject.codeAcademy.services.LikeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeControllers {
    @Autowired
    LikeServices likeServices;
    public LikeControllers(LikeServices likeServices) {
        this.likeServices = likeServices;
    }
    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId,
                                          @RequestParam Optional<Long> videoId) {
        return likeServices.getAllLikesWithParam(userId, videoId);
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest request) {
        return likeServices.createOneLike(request);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId) {
        return likeServices.getOneLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        likeServices.deleteOneLikeById(likeId);
    }




}
