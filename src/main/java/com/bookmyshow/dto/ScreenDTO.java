package com.bookmyshow.dto;

public class ScreenDTO {
    private Long id;
    private String name;
    private Integer totalSeats;
    private TheaterDTO theater;

    // Constructors
    public ScreenDTO() {}

    public ScreenDTO(Long id, String name, Integer totalSeats, TheaterDTO theater) {
        this.id = id;
        this.name = name;
        this.totalSeats = totalSeats;
        this.theater = theater;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getTotalSeats() { return totalSeats; }
    public void setTotalSeats(Integer totalSeats) { this.totalSeats = totalSeats; }

    public TheaterDTO getTheater() { return theater; }
    public void setTheater(TheaterDTO theater) { this.theater = theater; }
}