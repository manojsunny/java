package com.nit.dao;

import com.nit.model.Authentication;

public interface DataAccessing {
	
	public String authenticationOperation(String user, String password);

	public String authentication(Authentication authentication);

	public String employeeInformation(int eno);

}
