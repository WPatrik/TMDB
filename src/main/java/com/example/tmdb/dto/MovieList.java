package com.example.tmdb.dto;

import java.util.List;

public class MovieList {

    private List<MovieListItem> results;

    public MovieList() {
    }

    public MovieList(List<MovieListItem> movies) {
        this.results = movies;
    }

    public List<MovieListItem> getResults() {
        return results;
    }

    public void setResults(List<MovieListItem> results) {
        this.results = results;
    }
}
