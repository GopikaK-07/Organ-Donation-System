package com.clt.donor_service.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donor_id;
	private String donor_name;
	private String type_of_organ;
	
	// no -args constructor need for JPA(java presistence application programming interface)
	
	public Donor() {
		
	}
	
	// All-args constructor
	public Donor(Long donor_id, String donor_name, String type_of_organ) {
	    this.donor_id = donor_id;
	    this.donor_name = donor_name;
	    this.type_of_organ = type_of_organ;
	    
	}


	public Long getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(Long donor_id) {
		this.donor_id = donor_id;
	}

	public String getDonor_name() {
		return donor_name;
	}

	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}

	public String getType_of_organ() {
		return type_of_organ;
	}

	public void setType_of_organ(String type_of_organ) {
		this.type_of_organ = type_of_organ;
	}


	
	
}
