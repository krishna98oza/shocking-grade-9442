package com.masai.Service;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AdminException;
import com.masai.Exception.CurrentUserSessionException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.DriverException;
import com.masai.Model.Admin;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Customer;
import com.masai.Model.Driver;
import com.masai.Model.UserLoginDTO;
import com.masai.Repositary.AdminRepo;
import com.masai.Repositary.CurrentUserSessionRepo;
import com.masai.Repositary.CustomerRepo;
import com.masai.Repositary.DriverRepo;

@Service
public class UserLoginServiceimpl implements UserLoginService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private CurrentUserSessionRepo currRepo;

	@Override
	public CurrentUserSession login(UserLoginDTO dto) throws CustomerException, AdminException, DriverException {
		
			Optional<Admin> findAdmin = adminRepo.findByEmail(dto.getEmail());
			Optional<Customer> findCustomer = customerRepo.findByEmail(dto.getEmail());
			Optional<Driver> findDriver = driverRepo.findByEmail(dto.getEmail());
			
			String role = dto.getRole().toLowerCase();
			
			if(findAdmin.isPresent() && findCustomer.isEmpty()) {
				Admin currAdmin = findAdmin.get();
				Optional<CurrentUserSession> validAdminSession = currRepo.findById(currAdmin.getAdminId());
				if(validAdminSession.isPresent()) {
					throw new AdminException("Admin is currently Login Please Logout and then try");
				}
				else {
					if(currAdmin.getPassword().equals(dto.getPassword())) {
						String key = RandomStringUtils.randomAlphanumeric(6);
						CurrentUserSession curr = new CurrentUserSession();
						curr.setUuid(key);
						curr.setCurrRole("Admin");
						curr.setCurrStatus("Login Successfull");
						curr.setCurrUserId(currAdmin.getAdminId());
						return currRepo.save(curr);
					}
					else {
						throw new AdminException("Please Enter the correct Password");
					}
				}
			}
			else if(findAdmin.isEmpty() && findCustomer.isPresent()){
					Customer currCustomer = findCustomer.get();
					Optional<CurrentUserSession> validCustomerSession = currRepo.findById(currCustomer.getCustomerId());
					if(validCustomerSession.isPresent()) {
						throw new CustomerException("Customer is currently Login Please Logout and then try");
					}
					else {
						if(currCustomer.getPassword().equals(dto.getPassword())) {
							String key = RandomStringUtils.randomAlphanumeric(6);
							CurrentUserSession curr = new CurrentUserSession();
							curr.setUuid(key);
							curr.setCurrRole("Customer");
							curr.setCurrStatus("Login Successfull");
							curr.setCurrUserId(currCustomer.getCustomerId());
							return currRepo.save(curr);
						}
						else {
							throw new CustomerException("Please Enter the correct Password");
						}
					}
				}else if (findAdmin.isEmpty() && findCustomer.isEmpty() && findDriver.isPresent()) {
			        Driver currDriver = findDriver.get();
			        Optional<CurrentUserSession> validDriverSession = currRepo.findById(currDriver.getDriverId());
			        if (validDriverSession.isPresent()) {
			            throw new DriverException("Driver is currently Login Please Logout and then try");
			        } else {
			            if (currDriver.getPassword().equals(dto.getPassword())) {
			                String key = RandomStringUtils.randomAlphanumeric(6);
			                CurrentUserSession curr = new CurrentUserSession();
			                curr.setUuid(key);
			                curr.setCurrRole("Driver");
			                curr.setCurrStatus("Login Successful");
			                curr.setCurrUserId(currDriver.getDriverId());
			                return currRepo.save(curr);
			            }
			        }
				}
			else {
				throw new CustomerException("User is Not Registered");
			}
			return null;
		}

	@Override
	public String LogOut(String uuid) throws CurrentUserSessionException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> validAdminOrCustomer = currRepo.findByUuid(uuid);
		if(validAdminOrCustomer.isPresent()) {
			
			currRepo.delete(validAdminOrCustomer.get());
			return "User Logged Out Successfully";
			
		}
		else {
			throw new CurrentUserSessionException("User Not Logged In with this Credentials");
		}
	}

	
	
	

	
}
