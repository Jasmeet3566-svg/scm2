package com.scm.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "social_links")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class socialLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;
    private String title;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // Getters and setters
}
