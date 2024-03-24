package com.webProject.codeAcademy.responses;

import com.webProject.codeAcademy.entities.Like;
import lombok.Data;

@Data
public class LikeResponse {
    Long id;
    Long userId;
    Long videoId;

    public LikeResponse(Like entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.videoId = entity.getVideo().getId();
    }
}
