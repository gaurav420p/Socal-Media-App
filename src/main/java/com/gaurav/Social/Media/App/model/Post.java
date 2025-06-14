package com.gaurav.Social.Media.App.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caption;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    private String video;

    @ManyToOne
    private User user;

    @OneToMany
    private List<User> liked=new ArrayList<>();

    private LocalDateTime createdAt;

    @OneToMany
    private List<Comment> comments=new ArrayList<>();

}
