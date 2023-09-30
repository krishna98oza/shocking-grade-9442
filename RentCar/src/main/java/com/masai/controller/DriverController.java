package com.masai.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Driver;
import com.masai.service.DriverService;

@RestController
public class DriverController {
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> insertDriver(@Valid @RequestBody Driver driver){
		Driver addedDriver= driverService.insertDriver(driver);
		return new ResponseEntity<Driver>(addedDriver,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> viewDriverById(@PathVariable("id") Integer id){
		Driver foundDriver= driverService.viewDriverById(id);
		return new ResponseEntity<Driver>(foundDriver,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/drivers")
	public ResponseEntity<Driver> updateDriver(@RequestParam Integer id,
								@RequestParam Integer lic,
								@RequestParam Boolean avail) {
		Driver driver=driverService.updateDriver(id,lic,avail);
		return new ResponseEntity<Driver>(driver,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/drivers/{id}")
	public String deleteDriverById(@PathVariable("id") Integer id) {
		return driverService.deleteDriverById(id);
	}
	
	@GetMapping("/topDrivers")
	public ResponseEntity<List<Driver>> viewBestDrivers(){
		List<Driver> list=driverService.viewBestDriver();
		return new ResponseEntity<List<Driver>>(list,HttpStatus.ACCEPTED);
	}
}
