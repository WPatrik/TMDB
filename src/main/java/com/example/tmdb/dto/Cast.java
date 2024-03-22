package com.example.tmdb.dto;

public class Cast {

    private String name;

    private String known_for_department;

    private String profile_path;


    public Cast() {
    }

    public Cast(String name, String known_for_department, String profile_path) {
        this.name = name;
        this.known_for_department = known_for_department;
        this.profile_path = profile_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
