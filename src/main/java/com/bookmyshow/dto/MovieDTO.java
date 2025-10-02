package com.bookmyshow.dto;

import java.time.LocalDate;

public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private String genre;
    private String language;
    private LocalDate releaseDate;
    private String posterUrl;

    // Constructors
    public MovieDTO() {}

    public MovieDTO(Long id, String title, String description, Integer duration, 
                   String genre, String language, LocalDate releaseDate, String posterUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.genre = genre;
        this.language = language;
        this.releaseDate = releaseDate;
        this.posterUrl = posterUrl;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }
}