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
import com.masai.exception.AdminExceptions;
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
	public Admin saveAdmin(Admin admin) throws AdminExceptions {
		System.out.println(admin);
		return adminRepository.save(admin);
	}

	@Override
	public Admin update(Admin admin) throws AdminExceptions {
		Optional<Admin> opt = adminRepository.findById(admin.getUserId());
		if (opt.isPresent()) {
			//Admin existAdmin = opt.get();
			return adminRepository.save(admin);
		}
		throw new AdminExceptions("Invalid Id");
	}

	@Override
	public Admin delete(Integer id) throws AdminExceptions {
		Admin existingAdmin = adminRepository.findById(id).orElseThrow(() -> new AdminExceptions("Id is Invalid"));
		adminRepository.delete(existingAdmin);

		return existingAdmin;
	}

	@Override //all trips detail of customer
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminExceptions {
		//customer exception
		Optional<Customer> opt = customerRepository.findById(customerid);
		if(opt.isPresent()) {
			List<TripBooking> trips = tripRepository.findAll();
			return trips;
		
		}
		throw new AdminExceptions("Id is Invalid");
	}

	@Override

	public List<TripBooking> getTripsDriverwise() {
		
		List<TripBooking> list = tripRepository.findByDriverAscs();
		
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("Trips not found");
		
	}


	@Override
	public List<TripBooking> getTripsCustomerwise() {
		List<TripBooking> list = tripRepository.findByCustomeridAsce();
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
		 
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminExceptions {
		List<TripBooking> list = tripRepository.findByFromdate_timeAsce();
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("Trips not found");
	}

	@Override
	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId, LocalDate date) throws AdminExceptions {
		List<TripBooking> list = tripRepository.findByCustomerIdAndFromdate_time(customerId, date);
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("Trips not found for customer id "+customerId+" and date : "+date);
	}


}
