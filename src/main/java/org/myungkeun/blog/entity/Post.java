package org.myungkeun.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // title
    @Column(name = "title", nullable = false)
    private String title;

    // description
    @Column(name = "description", nullable = false)
    private String description;

    // content
    @Column(name = "content", nullable = false)
    private String content;


}
