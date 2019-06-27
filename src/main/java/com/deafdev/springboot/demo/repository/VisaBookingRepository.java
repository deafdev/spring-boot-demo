package com.deafdev.springboot.demo.repository;


import com.deafdev.springboot.demo.model.VisaBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaBookingRepository extends JpaRepository<VisaBooking,Long> {



}
