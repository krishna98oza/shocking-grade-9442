package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

	List<Driver> viewBestDriver();

	List<Driver> findByAvailable();
	
}
