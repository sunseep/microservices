package com.example.demo.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	OrganizationDTO org;
	
	public EmployeeDTO() {
	}
	
	
	
	public EmployeeDTO(String name, OrganizationDTO org) {
		super();
		this.name = name;
		this.org = org;
	}
	



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OrganizationDTO getOrg() {
		return org;
	}
	public void setOrg(OrganizationDTO org) {
		this.org = org;
	}

}
