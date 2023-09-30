package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Admin;
import com.masai.entity.CurrentUserSession;
import com.masai.entity.Customer;
import com.masai.entity.CustomerDTO;
import com.masai.entity.Driver;
import com.masai.exception.AdminException;
import com.masai.exception.DataNotFoundException;
import com.masai.exception.InvalidPasswordException;
import com.masai.exception.UserAlreadyExistWithUserIdException;
import com.masai.repository.AdminRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInImpl implements UserLogIn {
	@Autowired
	private AdminRepository adminRepository;
//
//	@Autowired
//	private DriverDao driverDao;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public String logIntoAccount(CustomerDTO userDto) {
		Optional<Customer> opt_customer = customerRepository.findById(userDto.getUserId());
//		Optional<Driver> opt_driver = driverDao.findById(userDto.getUserId());
//		Optional<Admin> opt_admin = adminDao.findById(userDto.getUserId());

		Integer userId = opt_customer.get().getUserId();

		Optional<CurrentUserSession> currentUserOptional = sessionRepository.findById(userId);

		if (!opt_customer.isPresent()) {
			throw new AdminException("user not found");
		}
		if (currentUserOptional.isPresent()) {
			throw new UserAlreadyExistWithUserIdException("User already logged in with this number");
		}
		if (opt_customer.get().getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(opt_customer.get().getUserId(), key,
					LocalDateTime.now());
			sessionRepository.save(currentUserSession);

			return currentUserSession.toString();
		} else {
			throw new InvalidPasswordException("Please Enter Valid Password");
		}

	}

	@Override
	public String logOutFromAccount(String key) {
		Optional<CurrentUserSession> currentUserOptional = sessionRepository.findByUuid(key);

		if (!currentUserOptional.isPresent()) {
			throw new DataNotFoundException("User is not logged in with this number");
		}

		CurrentUserSession currentUserSession = currentUserOptional.get();
		sessionRepository.delete(currentUserSession);

		return "Logged Out...";
	}

}
