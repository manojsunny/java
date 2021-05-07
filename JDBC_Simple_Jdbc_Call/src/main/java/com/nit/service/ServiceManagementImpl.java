package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.DataAccessing;
import com.nit.model.Authentication;

@Service("service")
public class ServiceManagementImpl implements ServiceManagement {

	@Autowired
	private DataAccessing dao;

	@Override
	public String credentials(String userName, String password) {
		//invoke dao method
		String result = dao.authenticationOperation(userName, password);
		return result;
	}

	@Override
	public String credentails(Authentication authentication) {
		//invoke dao method
		String result = dao.authentication(authentication);
		return result;
	}
	
	@Override
	public String employeeInformation(int eno) {
		//invoke method
		String name = dao.employeeInformation(eno);
		return name;
	}

}
