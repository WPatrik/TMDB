package com.example.tmdb.service;

import com.example.tmdb.domain.Movie;
import com.example.tmdb.dto.MovieDetailsItem;
import com.example.tmdb.dto.MovieListItem;
import com.example.tmdb.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieListItem> findAll() {
        return this.movieRepository.findAll()
                .stream()
                .map(MovieListItem::new).collect(Collectors.toList());
    }

    public MovieDetailsItem getMovieDetails(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow((() -> new EntityNotFoundException("Movie with id: " + id + " not found!")));
        return new MovieDetailsItem(movie);
    }
}
