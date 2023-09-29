package com.masai.service;

import java.util.List;

import com.masai.entity.TripBooking;
import com.masai.exception.InvalidIdException;


public interface TripService {

	
	public TripBooking AddTrip(TripBooking tb);
	public List<TripBooking> alltrip();
	public TripBooking updateTrip(TripBooking tb,Integer id)throws InvalidIdException;
	public String deletetrip(Integer id) throws InvalidIdException;
	public TripBooking tripEnd(Integer id)throws InvalidIdException;
}
