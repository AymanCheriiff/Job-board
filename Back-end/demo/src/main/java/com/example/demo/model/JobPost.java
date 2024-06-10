package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class JobPost {

    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Column(name = "image", length = 500000000)
    private String image;
    @Column(name = "video", length = 500000000)
    private String video;
    @ManyToOne
    private User user;
    @ManyToOne
    private Industry industry;

}
