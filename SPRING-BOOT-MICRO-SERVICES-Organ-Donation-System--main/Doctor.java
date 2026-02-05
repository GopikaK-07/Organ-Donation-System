package com.clt.doctor_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "doctors")

public class Doctor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctor_id;
	private String username;
	private String password;
	
	// no -args constructor need for JPA(java presistence application programming interface)
	
	public Doctor() {
		
	}
	
	// All-args constructor
	public Doctor(Long doctor_id, String username, String password) {
	    this.doctor_id = doctor_id;
	    this.setUsername(username);
	    this.setPassword(password);
	    
	}
	public Long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
