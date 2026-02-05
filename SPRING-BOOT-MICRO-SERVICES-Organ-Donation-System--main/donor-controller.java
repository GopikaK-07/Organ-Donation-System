package com.clt.donor_service.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clt.donor_service.entity.Donor;
import com.clt.donor_service.repository.DonorRepository;

@RestController
@RequestMapping("/donors")
public class DonorController {
	
	@Autowired
	private DonorRepository donorRepository;
	
	// to welcome to donors
	
	@PostMapping
	public Donor addDonor(@RequestBody Donor donor) {
		return donorRepository.save(donor);
	}
	
	// to get a all donors
	
	@GetMapping
	public List<Donor> getAlldonors(){
		return donorRepository.findAll();
	}
	
	// To get donor details by ID
	@GetMapping("/{donorId}")
	public ResponseEntity<Donor> getDonorById(@PathVariable Long donorId) {
	    return donorRepository.findById(donorId)
	            .map(donor -> ResponseEntity.ok(donor))
	            .orElse(ResponseEntity.notFound().build());
	}

	}
	
	
	
	


DONORCONTROLLER.JAVA
