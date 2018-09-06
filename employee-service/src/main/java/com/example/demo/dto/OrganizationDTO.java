package com.example.demo.dto;

import java.io.Serializable;

public class OrganizationDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String orgName;
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public OrganizationDTO() {
	
	}

	public OrganizationDTO(String orgName) {
		super();
		this.orgName = orgName;
	}
	

}
