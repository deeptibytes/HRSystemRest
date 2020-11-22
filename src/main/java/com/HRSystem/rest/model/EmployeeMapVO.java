package com.HRSystem.rest.model;

import java.util.HashMap;

import com.api.employee.beans.Emp;

public class EmployeeMapVO {
	
	HashMap<Integer, Emp> map;

	public EmployeeMapVO(HashMap<Integer, Emp> map) {
		super();
		this.map = map;
	}
	
	public EmployeeMapVO() {
		super();
		
	}

	public HashMap<Integer, Emp> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, Emp> map) {
		this.map = map;
	}
	
	

}
