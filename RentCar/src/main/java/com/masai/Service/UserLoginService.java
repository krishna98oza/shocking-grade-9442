package com.masai.Service;

import com.masai.Exception.AdminException;
import com.masai.Exception.CurrentUserSessionException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.DriverException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.UserLoginDTO;

public interface UserLoginService {

    public CurrentUserSession login(UserLoginDTO dto)throws CustomerException, AdminException, DriverException;
	
	public String LogOut(String uuid)throws CurrentUserSessionException; 
	
	
}
