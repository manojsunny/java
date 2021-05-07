package com.nit.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.model.Authentication;
import com.nit.service.ServiceManagement;
import com.nit.service.ServiceManagementImpl;

public class LoginCredentails {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext application = new ClassPathXmlApplicationContext("com/nit/configuration/applicationContext.xml");
		//get service bean
		ServiceManagement service = application.getBean("service", ServiceManagementImpl.class);
		try {
			//get scanner object
			Scanner sc = new Scanner(System.in);
			//set values
			System.out.println("Enter user :");
			String user = sc.next();
			System.out.println("Enter password :");
			String password = sc.next();
			/*System.out.println(service.credentials(user, password));*/
			//get Authentication object
			Authentication authentication = new Authentication();
			authentication.setUserName(user);
			authentication.setPass(password);
			System.out.println(service.credentails(authentication));
			
			//set values
			System.out.println("Enter emp no");
			int empno = sc.nextInt();
			System.out.println(service.employeeInformation(empno));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
