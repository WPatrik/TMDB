package com.example.tmdb.domain;

import com.example.tmdb.dto.CommentFormData;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "comment_body", columnDefinition = "TEXT")
    private String commentBody;

    @ManyToOne
    private Movie movie;

    public Comment() {
    }

    public Comment(Long id, String email, String commentBody, Movie movie) {
        this.id = id;
        this.email = email;
        this.commentBody = commentBody;
        this.movie = movie;
    }

    public Comment(CommentFormData commentFormData) {
        this.id = commentFormData.getMovieId();
        this.email = commentFormData.getEmail();
        this.commentBody = commentFormData.getCommentBody();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


}
