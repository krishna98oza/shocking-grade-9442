package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.entity.Admin;
import com.masai.entity.Cab;
import com.masai.entity.TripBooking;
import com.masai.exception.AdminException;



public interface AdminService {

	public Admin saveAdmin(Admin admin) throws AdminException;
	
	public Admin update(Admin admin) throws AdminException;
	
	public Admin delete(Integer id) throws AdminException;
	
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminException;
	
	public List<TripBooking> getTripsDriverwise();
	
	public List<TripBooking> getTripsCustomerwise();
	
	public List<TripBooking> getTripsDatewise() throws AdminException;
	
	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId,LocalDate date) throws AdminException;
	
	
	

}
