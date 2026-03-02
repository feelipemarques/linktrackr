package com.felipe.linktrackr_backend.ShortLink;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Entity
@Table(name = "shortlink")
@NoArgsConstructor
@Getter
@Setter
public class ShortLinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @URL
    @Column(nullable = false, columnDefinition = "TEXT")
    private String originalUrl;

    @Column(nullable = false, unique = true)
    private String shortCode;

    private LocalDateTime createdAt = LocalDateTime.from(LocalDateTime.now());

}
