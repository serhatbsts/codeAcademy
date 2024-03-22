package com.webProject.codeAcademy.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="to_like")
@Data
public class Like {
    @Id
    private Long id;
    Long videoId;
    Long userId;
    @Lob

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
