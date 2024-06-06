package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Industry {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "industry")
    private List<JobPost> jobPostList;
}
