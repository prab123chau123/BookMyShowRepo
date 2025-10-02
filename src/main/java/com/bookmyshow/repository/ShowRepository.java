package com.bookmyshow.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyshow.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    
    List<Show> findByMovieId(Long movieId);
    
    List<Show> findByScreenId(Long screenId);
    
    @Query("SELECT s FROM Show s WHERE s.movie.id = :movieId AND s.screen.theater.city = :city")
    List<Show> findByMovieIdAndCity(@Param("movieId") Long movieId, @Param("city") String city);
    
    @Query("SELECT s FROM Show s WHERE s.showTime BETWEEN :startTime AND :endTime")
    List<Show> findByShowTimeBetween(@Param("startTime") LocalDateTime startTime, 
                                   @Param("endTime") LocalDateTime endTime);
}