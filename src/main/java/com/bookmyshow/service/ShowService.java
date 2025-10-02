package com.bookmyshow.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.entity.Seat;
import com.bookmyshow.entity.Show;
import com.bookmyshow.repository.SeatRepository;
import com.bookmyshow.repository.ShowRepository;

@Service
public class ShowService {
    
    @Autowired
    private ShowRepository showRepository;
    
    @Autowired
    private SeatRepository seatRepository;
    
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
    
    public Optional<Show> getShowById(Long id) {
        return showRepository.findById(id);
    }
    
    public Show saveShow(Show show) {
        return showRepository.save(show);
    }
    
    public List<Show> getShowsByMovie(Long movieId) {
        return showRepository.findByMovieId(movieId);
    }
    
    public List<Show> getShowsByMovieAndCity(Long movieId, String city) {
        return showRepository.findByMovieIdAndCity(movieId, city);
    }
    
    public List<Show> getShowsByDateRange(LocalDateTime startTime, LocalDateTime endTime) {
        return showRepository.findByShowTimeBetween(startTime, endTime);
    }
    
    public List<Seat> getAvailableSeatsForShow(Long showId) {
        Optional<Show> showOpt = showRepository.findById(showId);
        if (showOpt.isPresent()) {
            Show show = showOpt.get();
            return seatRepository.findAvailableSeatsForShow(show.getScreen().getId(), showId);
        }
        return List.of();
    }
    
    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}