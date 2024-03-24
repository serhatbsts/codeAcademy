package com.webProject.codeAcademy.request;

import lombok.Data;

@Data
public class LikeCreateRequest {

    Long id;
    Long userId;
    Long videoId;
}
