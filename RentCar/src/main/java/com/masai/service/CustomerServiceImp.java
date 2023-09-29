package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.AddressRepository;
import com.masai.repository.CustomerRepository;
import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.InvalidIdException;


@Service
public class CustomerServiceImp implements CustomerService {
 
	@Autowired
	private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRpository;
	
	
	@Override
    	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public Customer findCustomer(Integer id) throws InvalidIdException {
	

		Customer ct=customerRepository.findById(id).orElseThrow(() -> new InvalidIdException("Customer with ID "+id+" does not exit.."));
		
		
		return ct;
		
	}
	@Override
	public Customer updateCustomer(Customer customer, Integer id) throws InvalidIdException {
		
		Customer c1=customerRepository.findById(id).orElseThrow(() -> new InvalidIdException("Customer with ID "+id+" does not exit.."));
		
	Integer aid=	c1.getAddress().getId();
		
		c1.setAddress(customer.getAddress());
		c1.setEmail(customer.getEmail());
		c1.setMobile(customer.getMobile());
		c1.setPassword(customer.getPassword());
		c1.setUsername(customer.getUsername());
		Address a1=addressRpository.findById(aid).orElseThrow(() -> new InvalidIdException("Address with ID "+aid+" does not exit.."));
		addressRpository.delete(a1);
		addressRpository.save(customer.getAddress());
		
		return c1;
	}


	@Override
	public String deleteCustomer(Integer id) throws InvalidIdException {
		// TODO Auto-generated method stub
		Customer ct=customerRepository.findById(id).orElseThrow(() -> new InvalidIdException("Customer with ID "+id+" does not exit.."));
		addressRpository.delete(ct.getAddress());
		customerRepository.delete(ct);
		
		return "delete...";
	}


	@Override
	public List<Customer> allCustomer() throws NullPointerException {
		List<Customer> c1  =customerRepository.findAll();
		if(c1.size()==0)
			throw new NullPointerException("EMPTY NO DATA AVAILABLE");
		return c1;
	}


	@Override
	public Customer vaildCustomer(String Email, String Password) throws InvalidIdException {
		// TODO Auto-generated method stub
		
		List<Customer> c1  =customerRepository.findAll();
		for(int i= 0; i < c1.size(); i++) {
			if(c1.get(i).getEmail().equals(Email) && c1.get(i).getPassword().equals(Password))
			     return c1.get(i);
			}
		 throw new InvalidIdException("Invalid Email and password");
	}





	

}
