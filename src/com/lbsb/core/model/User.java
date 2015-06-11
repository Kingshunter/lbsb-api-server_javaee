package com.lbsb.core.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 4818368211838356302L;
	
	private Integer id;
	
	private String name;
	
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
