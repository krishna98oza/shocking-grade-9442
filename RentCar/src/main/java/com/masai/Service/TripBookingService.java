package com.masai.Service;

import java.util.List;

import com.masai.Exception.CabException;
import com.masai.Exception.CurrentUserSessionException;
import com.masai.Exception.TripBookingException;
import com.masai.Model.Cab;
import com.masai.Model.TripBooking;
import com.masai.Model.TripBookingDTO;

public interface TripBookingService {

	List<Cab> searchByLocation(String pickUpLocation,String uuid)throws TripBookingException,CurrentUserSessionException;
	
	TripBooking BookRequest(Integer cabId,TripBooking tripBooking,String uuid) throws TripBookingException,CabException,CurrentUserSessionException;
	
	TripBooking AssignDriverByAdmin(Integer TripBookingId,String uuid)throws TripBookingException,CabException,CurrentUserSessionException;
	
	TripBookingDTO viewBookingById(Integer TripBookingId,String uuid )throws TripBookingException,CabException,CurrentUserSessionException;
	
	String MarkTripAsCompleted(Integer TripBookingId,String uuid)throws TripBookingException,CurrentUserSessionException;;
}
