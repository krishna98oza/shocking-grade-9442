package com.masai.service;

import java.util.List;

import com.masai.entity.Cab;
import com.masai.exception.DataNotFoundException;



public interface CabService {

public Cab updateCab(Integer id,String type, Integer rate) throws DataNotFoundException;
	
	public List<String> viewCabsOfType() throws DataNotFoundException;
	public int countCabsOfType() throws DataNotFoundException;
	
}

