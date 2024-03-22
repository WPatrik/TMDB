package com.example.tmdb.dto;

import com.example.tmdb.domain.Movie;
import jakarta.persistence.Column;

public class MovieDetailsItem {

    private Long id;
    private String title;
    private String imgUrl;
    private String actor;
    private Long year;
    private String studio;
    private String language;
    private String plot;

    public MovieDetailsItem(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.imgUrl = movie.getImage();
        this.actor = movie.getActor(); ;
        this.year = movie.getYear();
        this.studio = movie.getStudio();
        this.language = movie.getLanguage();
        this.plot = movie.getPlot();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
