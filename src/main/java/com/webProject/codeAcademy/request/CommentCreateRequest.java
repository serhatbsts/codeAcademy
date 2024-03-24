package com.webProject.codeAcademy.request;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long id;
    Long userId;
    Long videoId;
    String text;
}
