package com.masai.Service;



import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.CurrentUserSessionException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.TripBookingException;
import com.masai.Model.Admin;
import com.masai.Model.TripBooking;


public interface AdminService {

	Admin insertAdmin(Admin admin) throws AdminException;
	
    Admin updateAdmin(Admin admin,String uuid) throws AdminException,CurrentUserSessionException;
	
    Admin deleteAdmin(Integer adminId,String uuid) throws AdminException,CurrentUserSessionException;
    
    List<TripBooking> getAllTrips(String uuid)throws AdminException, TripBookingException, CurrentUserSessionException;
	  
    List<TripBooking> getTripsCabwise(String carType, String uuid)throws TripBookingException, CurrentUserSessionException;
    
    List<TripBooking> getTripsCustomerwise(Integer customerId, String uuid)throws TripBookingException,CustomerException, CurrentUserSessionException;
    
    List<TripBooking> getAllTripsForDays(Integer customerId, String fromDateTime, String toDateTime, String uuid)throws TripBookingException,CustomerException, CurrentUserSessionException;
}
