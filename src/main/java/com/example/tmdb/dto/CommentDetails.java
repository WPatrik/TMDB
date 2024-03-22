package com.example.tmdb.dto;

import com.example.tmdb.domain.Comment;

public class CommentDetails {
    private String email;

    private String commentBody;

    public CommentDetails(Comment comment) {
        this.email = comment.getEmail();
        this.commentBody = comment.getCommentBody();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
