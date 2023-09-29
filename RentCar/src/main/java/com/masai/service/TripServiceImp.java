package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Driver;
import com.masai.entity.TripBooking;
import com.masai.exception.DriverNotFoundException;
import com.masai.exception.InvalidIdException;
import com.masai.repository.CustomerRepository;
import com.masai.repository.DriverRepository;
import com.masai.repository.TripRepository;


@Service
public class TripServiceImp implements TripService {
    @Autowired
	TripRepository tripRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DriverRepository driverRepository;
	
	@Override
	public TripBooking AddTrip(TripBooking tb) throws InvalidIdException {
		
		customerRepository.findById(tb.getCustomerId()).orElseThrow(() -> new InvalidIdException("Customer with ID "+tb.getCustomerId()+" does not exit.."));
		List<Driver> drivers= driverRepository.findByAvailable() ;
		if(drivers.size()==0)
		{
			throw new DriverNotFoundException("Sorry No driver Available just now...");
		}
//		drivers.forEach((e)->System.out.println(e.getUserId()));
//		System.out.println(drivers.size());
		drivers.get(0).setAvailable(false);
		driverRepository.save(drivers.get(0));
		 Integer km = tb.getKm();
	     Integer price=drivers.get(0).getCab().getRatePerKm();
	     tb.setTotalamount(km*price);
		 tb.setDriver(drivers.get(0));
		return tripRepository.save(tb);
	}

	
	@Override
	public List<TripBooking> alltrip() {
		
		return tripRepository.findAll(); 
	}

	@Override
	public TripBooking updateTrip(TripBooking tb,Integer id) throws InvalidIdException {
		
	
		TripBooking c1=tripRepository.getById(id);
		
		c1.setCustomerId(tb.getCustomerId());
		c1.setFrom_location(tb.getFrom_location());
		c1.setTo_location(tb.getTo_location());
		c1.setFromdate_time(tb.getFromdate_time());
		c1.setTodate_time(tb.getTodate_time());
		c1.setKm(tb.getKm());
		
		tripRepository.save(c1);		
		return c1;
	}

	@Override
	public String deletetrip(Integer id) throws InvalidIdException {
		TripBooking ct=tripRepository.findById(id).orElseThrow(() -> new InvalidIdException("TripBooking with ID "+id+" does not exit.."));
		
		ct.setDriver(null);
		tripRepository.delete(ct);

		return "delete...";
	}


	@Override
	public TripBooking tripEnd(Integer id) throws InvalidIdException {
		
		TripBooking ct=tripRepository.findById(id).orElseThrow(() -> new InvalidIdException("TripBooking with ID "+id+" does not exit.."));
	    
		Integer driverid=ct.getDriver().getUserId();
		Driver dt=driverRepository.findById(driverid).orElseThrow(() -> new InvalidIdException("Drive with ID "+driverid+" does not exit.."));
	 
		dt.setAvailable(true);
		driverRepository.save(dt);
		ct.setPayment(true);
	     
	     
		return tripRepository.save(ct);
	}

}
