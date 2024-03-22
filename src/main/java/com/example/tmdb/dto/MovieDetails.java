package com.example.tmdb.dto;

import java.util.List;

public class MovieDetails {
    private String original_language;

    private String overview;

    private  String release_date;

    private String title;

    private String poster_path;

    private List<ProductionCompanies> production_companies;

    private List<Cast> cast;

    public MovieDetails() {
    }


    public MovieDetails(String original_language, String overview, String release_date, String title, String posterPath, List<ProductionCompanies> production_companies, List<Cast> cast) {
        this.original_language = original_language;
        this.overview = overview;
        this.release_date = release_date;
        this.title = title;
        poster_path = posterPath;
        this.production_companies = production_companies;
        this.cast = cast;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductionCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }
}
