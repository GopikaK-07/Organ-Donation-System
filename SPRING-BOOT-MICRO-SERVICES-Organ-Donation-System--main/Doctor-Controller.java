package com.clt.doctor_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clt.doctor_service.entity.Doctor;
import com.clt.doctor_service.repository.DoctorRepository;

	@RestController
	@RequestMapping("/doctors")
	public class DoctorController {
		
		@Autowired
		private DoctorRepository doctorRepository;
		
		// to welcome to doctors
		
		@PostMapping
		public Doctor addDoctor (@RequestBody Doctor doctor) {
			return doctorRepository.save(doctor);
		}
		
		// to get a all doctors
		
		@GetMapping
		public List<Doctor> getAlldoctors(){
			return doctorRepository.findAll();
		}
		
		// To get doctor details by ID
		@GetMapping("/{doctorId}")
		public ResponseEntity<Doctor> getDoctorById(@PathVariable Long doctorId) {
		    return doctorRepository.findById(doctorId)
		            .map(doctor -> ResponseEntity.ok(doctor))
		            .orElse(ResponseEntity.notFound().build());
		}
		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody Doctor loginDoctor) {
		    Doctor doctor = doctorRepository.findByUsername(loginDoctor.getUsername())
		            .orElse(null);

		    if (doctor != null && doctor.getPassword().equals(loginDoctor.getPassword())) {
		        return ResponseEntity.ok(new LoginResponse("Login successful", doctor.getDoctor_id()));
		    } else {
		        return ResponseEntity.status(401).body("Invalid credentials");
		    }
		}

		// Create a response class to send doctor_id along with a message
		public static class LoginResponse {
		    private String message;
		    private Long doctorId;

		    public LoginResponse(String message, Long doctorId) {
		        this.message = message;
		        this.doctorId = doctorId;
		    }

		    public String getMessage() {
		        return message;
		    }

		    public Long getDoctorId() {
		        return doctorId;
		    }
		}



		}
