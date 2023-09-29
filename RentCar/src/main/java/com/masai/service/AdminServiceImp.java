package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Admin;
import com.masai.entity.Cab;
import com.masai.entity.Customer;
import com.masai.entity.Driver;
import com.masai.entity.TripBooking;
import com.masai.exception.AdminException;
import com.masai.repository.AdminRepository;
import com.masai.repository.CabRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.DriverRepository;
import com.masai.repository.TripRepository;


@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private DriverRepository driverRepository;
	
	@Autowired
	private CabRepository cabRepository;
	
	@Autowired
	private TripRepository tripRepository;

	@Override
	public Admin saveAdmin(Admin admin) throws AdminException {
		System.out.println(admin);
		return adminRepository.save(admin);
	}

	@Override
	public Admin update(Admin admin) throws AdminException {
		Optional<Admin> opt = adminRepository.findById(admin.getUserId());
		if (opt.isPresent()) {
			//Admin existAdmin = opt.get();
			return adminRepository.save(admin);
		}
		throw new AdminException("Invalid Id");
	}

	@Override
	public Admin delete(Integer id) throws AdminException {
		Admin existingAdmin = adminRepository.findById(id).orElseThrow(() -> new AdminException("Id is Invalid"));
		adminRepository.delete(existingAdmin);

		return existingAdmin;
	}

	@Override //all trips detail of customer
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminException {
		//customer exception
		Optional<Customer> opt = customerRepository.findById(customerid);
		if(opt.isPresent()) {
			List<TripBooking> trips = tripRepository.findAll();
			return trips;
		
		}
		throw new AdminException("Id is Invalid");
	}

	@Override

	public List<TripBooking> getTripsDriverwise() {
		
		List<TripBooking> list = tripRepository.findByDriverAscs();
		
		if(list.size() > 0)
			return list;
		else
			throw new AdminException("Trips not found");
		
	}


	@Override
	public List<TripBooking> getTripsCustomerwise() {
		List<TripBooking> list = tripRepository.findByCustomeridAsce();
		if(list.size() > 0)
			return list;
		else
			throw new AdminException("No trips found");
		 
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminException {
		List<TripBooking> list = tripRepository.findByFromdate_timeAsce();
		if(list.size() > 0)
			return list;
		else
			throw new AdminException("Trips not found");
	}

	@Override
	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId, LocalDate date) throws AdminException {
		List<TripBooking> list = tripRepository.findByCustomerIdAndFromdate_time(customerId, date);
		if(list.size() > 0)
			return list;
		else
			throw new AdminException("Trips not found for customer id "+customerId+" and date : "+date);
	}


}
