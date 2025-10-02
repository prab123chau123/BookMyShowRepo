package com.bookmyshow.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.entity.BookingSeat;
import com.bookmyshow.entity.Seat;
import com.bookmyshow.entity.Show;
import com.bookmyshow.repository.BookingRepository;
import com.bookmyshow.repository.BookingSeatRepository;
import com.bookmyshow.repository.SeatRepository;
import com.bookmyshow.repository.ShowRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private ShowRepository showRepository;
    
    @Autowired
    private SeatRepository seatRepository;
    
    @Autowired
    private BookingSeatRepository bookingSeatRepository;
    
    @Transactional
    public Booking createBooking(String customerName, String customerEmail, String customerPhone,
                               Long showId, List<Long> seatIds) {
        
        Optional<Show> showOpt = showRepository.findById(showId);
        if (showOpt.isEmpty()) {
            throw new RuntimeException("Show not found");
        }
        
        Show show = showOpt.get();
        List<Seat> seats = seatRepository.findAllById(seatIds);
        
        if (seats.size() != seatIds.size()) {
            throw new RuntimeException("Some seats not found");
        }
        
        // Check if seats are available
        List<Seat> availableSeats = seatRepository.findAvailableSeatsForShow(
            show.getScreen().getId(), showId);
        
        for (Seat seat : seats) {
            if (!availableSeats.contains(seat)) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is not available");
            }
        }
        
        // Calculate total amount
        BigDecimal totalAmount = show.getPrice().multiply(BigDecimal.valueOf(seats.size()));
        
        // Create booking
        Booking booking = new Booking(customerName, customerEmail, customerPhone, totalAmount, show);
        booking = bookingRepository.save(booking);
        
        // Create booking seats
        for (Seat seat : seats) {
            BookingSeat bookingSeat = new BookingSeat(booking, seat);
            bookingSeatRepository.save(bookingSeat);
        }
        
        return booking;
    }
    
    public List<Booking> getBookingsByEmail(String email) {
        return bookingRepository.findByCustomerEmail(email);
    }
    
    public List<Booking> getBookingsByPhone(String phone) {
        return bookingRepository.findByCustomerPhoneOrderByBookingTimeDesc(phone);
    }
    
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
    
    @Transactional
    public void cancelBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus(Booking.BookingStatus.CANCELLED);
            bookingRepository.save(booking);
        }
    }
}