package com.masai.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.masai.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEmail(String email);
}
