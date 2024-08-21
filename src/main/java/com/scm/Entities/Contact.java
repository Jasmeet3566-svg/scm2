package com.scm.Entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    private String id;
    
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    private String description;
    private boolean favourit = false;
    private String websiteLink;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<socialLinks> links = new ArrayList<>();
    
    // Getters and setters
}
