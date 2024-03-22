package com.example.tmdb.dto;

public class CommentFormData {

    private Long movieId;

    private String email;

    private String commentBody;

    public CommentFormData() {
    }

    public CommentFormData(Long movieId, String email, String commentBody) {
        this.movieId = movieId;
        this.email = email;
        this.commentBody = commentBody;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
