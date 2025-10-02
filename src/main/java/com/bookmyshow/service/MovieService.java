package com.bookmyshow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.repository.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
    
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre);
    }
    
    public List<Movie> getMoviesByLanguage(String language) {
        return movieRepository.findByLanguageIgnoreCase(language);
    }
    
    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<String> getAllGenres() {
        return movieRepository.findAllGenres();
    }
    
    public List<String> getAllLanguages() {
        return movieRepository.findAllLanguages();
    }
    
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}