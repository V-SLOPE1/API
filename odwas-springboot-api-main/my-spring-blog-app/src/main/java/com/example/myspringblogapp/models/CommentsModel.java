package com.example.myspringblogapp.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comment_items")

public class CommentsModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;

    private String title;

    private String description;

    private int upVotes;

    private Instant createdAt;

    private Instant updatedAt;

    @Override
    public String toString() {
        return String.format("ArticleItem{id=%d, author='%s', title='%s', description='%s', upVotes=%d, createdAt='%s', updatedAt='%s'}",
                id, author, title, description, upVotes, createdAt, updatedAt);
    }
}
