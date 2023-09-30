package com.masai.service;



import java.util.List;

import com.masai.entity.Customer;
import com.masai.exception.InvalidIdException;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	public Customer findCustomer(Integer id)throws InvalidIdException;
	public Customer updateCustomer(Customer customer,Integer id)throws InvalidIdException;
	public String deleteCustomer(Integer id)throws InvalidIdException;
	public List<Customer> allCustomer()throws NullPointerException;
	public Customer vaildCustomer(String Email,String Password)throws InvalidIdException;
	
}
