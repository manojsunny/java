package com.nit.service;

import com.nit.model.Authentication;

public interface ServiceManagement {

	public String credentials(String userName, String password);
	
	public String credentails(Authentication authentication);

	public String employeeInformation(int eno);

}
