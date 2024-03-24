package com.webProject.codeAcademy.request;

import lombok.Data;

@Data
public class VideoCreateRequest {
    Long id;
    String text;
    String title;
    Long userId;
}
