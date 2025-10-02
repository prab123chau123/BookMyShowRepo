package com.bookmyshow.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookmyshow.dto.ShowDTO;
import com.bookmyshow.dto.MovieDTO;
import com.bookmyshow.dto.TheaterDTO;
import com.bookmyshow.dto.ScreenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.entity.Seat;
import com.bookmyshow.entity.Show;
import com.bookmyshow.service.ShowService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "*")
public class ShowController {
    
    @Autowired
    private ShowService showService;
    
    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Optional<Show> show = showService.getShowById(id);
        return show.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Show> createShow(@Valid @RequestBody Show show) {
        Show savedShow = showService.saveShow(show);
        return ResponseEntity.ok(savedShow);
    }
    
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ShowDTO>> getShowsByMovie(@PathVariable Long movieId) {
        List<Show> shows = showService.getShowsByMovie(movieId);
        List<ShowDTO> showDTOs = shows.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(showDTOs);
    }
    
    @GetMapping("/movie/{movieId}/city/{city}")
    public ResponseEntity<List<ShowDTO>> getShowsByMovieAndCity(@PathVariable Long movieId, 
                                                           @PathVariable String city) {
        List<Show> shows = showService.getShowsByMovieAndCity(movieId, city);
        List<ShowDTO> showDTOs = shows.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(showDTOs);
    }
    
    @GetMapping("/date-range")
    public ResponseEntity<List<Show>> getShowsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        return ResponseEntity.ok(showService.getShowsByDateRange(startTime, endTime));
    }
    
    @GetMapping("/{id}/available-seats")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long id) {
        List<Seat> availableSeats = showService.getAvailableSeatsForShow(id);
        return ResponseEntity.ok(availableSeats);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        Optional<Show> show = showService.getShowById(id);
        if (show.isPresent()) {
            showService.deleteShow(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    private ShowDTO convertToDTO(Show show) {
        MovieDTO movieDTO = new MovieDTO(
            show.getMovie().getId(),
            show.getMovie().getTitle(),
            show.getMovie().getDescription(),
            show.getMovie().getDuration(),
            show.getMovie().getGenre(),
            show.getMovie().getLanguage(),
            show.getMovie().getReleaseDate(),
            show.getMovie().getPosterUrl()
        );
        
        TheaterDTO theaterDTO = new TheaterDTO(
            show.getScreen().getTheater().getId(),
            show.getScreen().getTheater().getName(),
            show.getScreen().getTheater().getAddress(),
            show.getScreen().getTheater().getCity()
        );
        
        ScreenDTO screenDTO = new ScreenDTO(
            show.getScreen().getId(),
            show.getScreen().getName(),
            show.getScreen().getTotalSeats(),
            theaterDTO
        );
        
        return new ShowDTO(
            show.getId(),
            show.getShowTime(),
            show.getPrice(),
            movieDTO,
            screenDTO
        );
    }
}