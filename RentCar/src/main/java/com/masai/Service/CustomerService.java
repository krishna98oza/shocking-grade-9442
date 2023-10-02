package com.masai.Service;



import java.util.List;

import com.masai.Exception.CurrentUserSessionException;
import com.masai.Exception.CustomerException;
import com.masai.Model.Customer;

public interface CustomerService {

	Customer insertCustomer(Customer customer) throws CustomerException;
	
	Customer updateCustomer(Customer customer,String uuid) throws CustomerException, CurrentUserSessionException;
	
	Customer deleteCustomer(Integer customerId,String uuid)  throws CustomerException, CurrentUserSessionException;
	
	List<Customer> viewCustomer(String uuid)  throws CustomerException, CurrentUserSessionException;
	
	Customer viewCustomer(Integer customerId, String uuid) throws CustomerException, CurrentUserSessionException;
	

	
	
}
