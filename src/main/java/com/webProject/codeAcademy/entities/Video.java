package com.webProject.codeAcademy.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="video")
@Data
public class Video {
    @Id
    private Long id;
    Long userId;
    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
