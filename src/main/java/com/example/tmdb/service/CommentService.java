package com.example.tmdb.service;

import com.example.tmdb.domain.Comment;
import com.example.tmdb.domain.Movie;
import com.example.tmdb.dto.CommentDetails;
import com.example.tmdb.dto.CommentFormData;
import com.example.tmdb.repository.CommentRepository;
import com.example.tmdb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    private final MovieRepository movieRepository;

    private CommentDetails commentDetails;

    @Autowired
    public CommentService(CommentRepository commentRepository, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
    }

    public Comment createComment(CommentFormData commentFormData) {
        Comment result = null;
        Movie movieToComment = movieRepository.findById(commentFormData.getMovieId()).orElse(null);

        if (movieToComment != null) {
            result = new Comment(commentFormData);
            movieToComment.getComments().add(result);
            result.setMovie(movieToComment);
            commentRepository.save(result);
        }
        return result;
    }

}
