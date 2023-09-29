package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Cab;
import com.masai.entity.Driver;
import com.masai.exception.DriverNotFoundException;
import com.masai.exception.InvalidIdException;
import com.masai.repository.AddressRepository;
import com.masai.repository.CabRepository;
import com.masai.repository.DriverRepository;
@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private CabRepository cabRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Driver insertDriver(Driver driver) {
		
		return driverRepository.save(driver);
	}

	@Override
	public Driver viewDriverById(Integer id) throws InvalidIdException {
		if(id<1)
			throw new InvalidIdException("Id should be more than 1");
		
		Optional<Driver> opt=driverRepository.findById(id);
		
		return opt.orElseThrow(() -> new DriverNotFoundException("No Driver found for id: "+id));
	}

	@Override
	public Driver updateDriver(Integer id,Integer license, Boolean available) throws DriverNotFoundException{
		Optional<Driver> opt= driverRepository.findById(id);
		if(opt.isPresent()) {

			Driver fDriver=opt.get();
			fDriver.setLicenseNo(license);
			fDriver.setAvailable(available);
			Cab fCab= fDriver.getCab();
			fCab.setDriver(fDriver);
			cabRepository.save(fCab);
			return driverRepository.save(fDriver);

		}
			
		else
			throw new DriverNotFoundException("No Driver found ");
	}

	@Override

	public String deleteDriverById(Integer id) throws DriverNotFoundException{
          Driver d1=driverRepository.findById(id).orElseThrow(()-> new DriverNotFoundException("No Driver found"));
        
          cabRepository.deleteById(d1.getCab().getCabId());
        addressRepository.delete(d1.getAddress());
        driverRepository.delete(d1);
			
	
		return "Driver Id "+id+ " deleted ";
	}

	@Override
	public List<Driver> viewBestDriver() throws DriverNotFoundException {
		List<Driver> drivers= driverRepository.viewBestDriver();
		if(drivers.size()>0)
			return drivers;
		else
			throw new DriverNotFoundException("No Driver found with rating>=4.5");
	}

	
	

}
