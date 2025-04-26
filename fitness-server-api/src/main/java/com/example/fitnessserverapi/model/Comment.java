package com.example.fitnessserverapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class Comment {

    @MongoId
    private String commentId;

//    private String postId;
    private String userId;
    private String comment;

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Comment(String userId, String comment) {
        this.userId = userId;
        this.comment = comment;
    }
}
