package com.example.tmdb.controller;

import com.example.tmdb.dto.MovieDetails;
import com.example.tmdb.dto.MovieList;
import com.example.tmdb.service.MovieService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<?> getMovies() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NGIyNjc0ZGNiYTJmNTQzMjhmMGZlZjlkN2FiZmU0NCIsInN1YiI6IjVjOGEzYzhlMGUwYTI2MGI2MGMzNjIwMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VV1-jBuJFSiIH1-sjdC0RgcDRbiGCZm6pbN6KBeeVlU")
                .build();

        Response response = client.newCall(request).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MovieList movieList = objectMapper.readValue(response.body().string(), MovieList.class);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetails> getMovieDetails(@PathVariable Long id) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/" + id + "?language=en-US")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NGIyNjc0ZGNiYTJmNTQzMjhmMGZlZjlkN2FiZmU0NCIsInN1YiI6IjVjOGEzYzhlMGUwYTI2MGI2MGMzNjIwMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VV1-jBuJFSiIH1-sjdC0RgcDRbiGCZm6pbN6KBeeVlU")
                .build();

        Response response = client.newCall(request).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MovieDetails movieDetails = objectMapper.readValue(response.body().string(), MovieDetails.class);
        return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }

}
