package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
    @Column(name = "image", length = 500000000)
    private String image;
    @ManyToOne
    private User user;
    @ManyToOne
    private Industry industry;

}
