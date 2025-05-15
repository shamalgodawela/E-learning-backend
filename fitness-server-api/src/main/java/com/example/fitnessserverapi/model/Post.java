package com.example.fitnessserverapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;

// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "posts")
//@Configuration
//@EnableMongoAuditing

public class Post {

    @Id
    private String id;

    private String postUId;
    private String title;
    private String content;
    private List<String> image;
    private List<Comment> comments = new ArrayList<>();
    private boolean published;

    public void setId(String id) {
        this.id = id;
    }

    public void setPostUId(String postUId) {
        this.postUId = postUId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getId() {
        return id;
    }

    public String getPostUId() {
        return postUId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getImage() {
        return image;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public boolean isPublished() {
        return published;
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    private int likes;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;


    public Post( String title, String content, boolean published) {

        this.title = title;
        this.content = content;
        this.published = published;
    }

    public Post( String title, String content, List<String> image, boolean published) {

        this.title = title;
        this.content = content;
        this.image = image;
        this.published = published;
    }


}
