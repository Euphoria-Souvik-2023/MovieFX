package com.example.moviefx.pojo;

public class Movie {
    private String title,description,releaseYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Movie(String title, String description, String releaseYear) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }
}
