package com.nit.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nit.model.Authentication;

@Repository("dao")
public class DataAccessingImpl implements DataAccessing {

	@Autowired
	private SimpleJdbcCall call;

	@Override
	public String authenticationOperation(String user, String password) {
		//set PL/SQL procedure name
		call.setProcedureName("P_AUTHENTICATION");
		//prepare map of IN parameter name and values
		Map<String, Object> map = Map.of("USERNAME", user, "PASS", password);
		//execute call PL/SQL
		Map<String, Object> out = call.execute(map);
		//gather result
		return (String) out.get("RESULT");

	}
	
	@Override
	public String authentication(Authentication authentication) {
		//set PL/SQL procedure name
		call.setProcedureName("P_AUTHENTICATION");
		//prepare map of object
		Map<String, Object> map = call.execute(new BeanPropertySqlParameterSource(authentication));
		return (String)map.get("RESULT");
	}
	
	@Override
	public String employeeInformation(int eno) {
		//set PL/SQL procedure name
		call.setProcedureName("P_EMPLOYEEINFORMATION");
		//prepare map of object
		Map<String, Object> map = Map.of("ENO", eno);
		//prepare map of object
		Map<String, Object> out = call.execute(map);
		return (String)out.get("NAME");
	}

}
