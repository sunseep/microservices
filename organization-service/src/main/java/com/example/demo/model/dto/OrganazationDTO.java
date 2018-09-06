package com.example.demo.model.dto;

import java.io.Serializable;

public class OrganazationDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrganazationDTO(String name) {
		super();
		this.name = name;
	}
	
	

}
