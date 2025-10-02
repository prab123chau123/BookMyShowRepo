package com.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    
    List<Theater> findByCityIgnoreCase(String city);
    
    List<Theater> findByNameContainingIgnoreCase(String name);
}