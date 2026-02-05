package com.clt.recipient_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.clt.recipient_service.dto.DonorDTO;
import com.clt.recipient_service.dto.RecipientResponseDTO;
import com.clt.recipient_service.entity.Recipient;
import com.clt.recipient_service.repository.RecipientRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recipients")
public class RecipientController {
	@Autowired
	private RecipientRepository recipientRepository ;
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	//create a method to place a recipients requests
	
	@PostMapping("/placeRecipient")
	public Mono<ResponseEntity<RecipientResponseDTO>> placeRecipient(@RequestBody Recipient recipient){
		return webClientBuilder.build()
				.get()
				.uri("http://localhost:8081/donors/{donor_id}", recipient.getDonorId())
				.retrieve()
				.onStatus(status -> status.value() == 404,clientResponse ->{
					return Mono.error(new RuntimeException("your request is not found with id : " + recipient.getDonorId()));
					
				})
				.bodyToMono(DonorDTO.class)
				.map(donorDTO -> {
					RecipientResponseDTO responseDTO = new RecipientResponseDTO();
					
					
					responseDTO.setRecipient_name(recipient.getRecipient_name());
					responseDTO.setRecipient_age(recipient.getRecipient_age());
					responseDTO.setDonor_name(donorDTO.getDonor_name());
					responseDTO.setType_of_organ(donorDTO.getType_of_organ());
					
					
					
					// save the recipient details
					
					recipientRepository.save(recipient);
					
					responseDTO.setDonorId(recipient.getDonorId());
					
					responseDTO.setRecipient_Id(recipient.getRecipientId());
				
					return ResponseEntity.ok(responseDTO);
				});
				}
	
	//Get all recipient details
	
	@GetMapping
	public List<Recipient> getAllRecipients(){
		return recipientRepository.findAll();
	}

	}
