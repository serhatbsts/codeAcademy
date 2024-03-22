package com.webProject.codeAcademy.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class Comment {
    @Id
    private Long id;

    Long videoId;
    Long userId;
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
