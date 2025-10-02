package com.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyshow.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    
    List<Seat> findByScreenId(Long screenId);
    
    @Query("SELECT s FROM Seat s WHERE s.screen.id = :screenId AND s.id NOT IN " +
           "(SELECT bs.seat.id FROM BookingSeat bs WHERE bs.booking.show.id = :showId)")
    List<Seat> findAvailableSeatsForShow(@Param("screenId") Long screenId, @Param("showId") Long showId);
}