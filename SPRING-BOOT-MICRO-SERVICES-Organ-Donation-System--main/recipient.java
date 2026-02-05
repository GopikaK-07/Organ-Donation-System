package com.clt.recipient_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recipients")
public class Recipient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recipient_Id;
	
	private Long donorId;
	private String recipient_name;
	private int recipient_age;
	
	
	public Recipient() {
		
	}
	public Recipient(Long recipient_Id,Long donorId,String recipient_name,int recipient_age) {
		this.recipient_Id=recipient_Id;
		this.setDonorId(donorId);
		this.setRecipient_name(recipient_name);
		this.setRecipient_age(recipient_age);
	}
	public Long getRecipientId() {
		return recipient_Id;
	}
	public void setRecipientId(Long recipient_Id ) {
		this.recipient_Id = recipient_Id;
	}
	public Long getDonorId() {
		return donorId;
	}
	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}
	public String getRecipient_name() {
		return recipient_name;
	}
	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}
	public int getRecipient_age() {
		return recipient_age;
	}
	public void setRecipient_age(int recipient_age) {
		this.recipient_age = recipient_age;
	}
	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}


}
