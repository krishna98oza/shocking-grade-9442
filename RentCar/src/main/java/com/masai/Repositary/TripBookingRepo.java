package com.masai.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.TripBooking;

@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking, Integer>{

}
