package com.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyshow.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    List<Booking> findByCustomerEmail(String customerEmail);
    
    List<Booking> findByShowId(Long showId);
    
    @Query("SELECT b FROM Booking b WHERE b.customerPhone = :phone ORDER BY b.bookingTime DESC")
    List<Booking> findByCustomerPhoneOrderByBookingTimeDesc(@Param("phone") String phone);
}