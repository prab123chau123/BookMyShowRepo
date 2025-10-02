package com.bookmyshow.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShowDTO {
    private Long id;
    private LocalDateTime showTime;
    private BigDecimal price;
    private MovieDTO movie;
    private ScreenDTO screen;

    // Constructors
    public ShowDTO() {}

    public ShowDTO(Long id, LocalDateTime showTime, BigDecimal price, MovieDTO movie, ScreenDTO screen) {
        this.id = id;
        this.showTime = showTime;
        this.price = price;
        this.movie = movie;
        this.screen = screen;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getShowTime() { return showTime; }
    public void setShowTime(LocalDateTime showTime) { this.showTime = showTime; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public MovieDTO getMovie() { return movie; }
    public void setMovie(MovieDTO movie) { this.movie = movie; }

    public ScreenDTO getScreen() { return screen; }
    public void setScreen(ScreenDTO screen) { this.screen = screen; }
}