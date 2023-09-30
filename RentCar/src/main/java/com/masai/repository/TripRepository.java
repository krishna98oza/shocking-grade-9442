package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.TripBooking;

@Repository
public interface TripRepository extends JpaRepository<TripBooking, Integer>{

	List<TripBooking> findByDriverAscs();

	List<TripBooking> findByCustomeridAsce();

	List<TripBooking> findByFromdate_timeAsce();

	List<TripBooking> findByCustomerIdAndFromdate_time(Integer customerId, LocalDate date);

}
