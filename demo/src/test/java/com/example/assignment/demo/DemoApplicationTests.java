package com.example.assignment.demo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.assignment.demo.model.Contact;
import com.example.assignment.demo.repository.ContactRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ContactRepository contactRepository;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testcontactCreation() {
		
		Contact contact = new Contact();
		contact.setAddress("abc");
		contact.setEmail("abc@gmail.com");
		contact.setName("Paul");
		contact.setPhoneNumber("1234567890");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Contact> request = new HttpEntity<>(contact, headers);
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity("http://localhost:"+port+"/contactManagementSystem/register", request, Long.class);
		Long createdContactId = responseEntity.getBody();
		
		assertThat(createdContactId).isNotNull();
	}
	
	
	@Test
	public void testDeleteContact() {
		
		long contactId = 1;
		ResponseEntity<Void> ResponseEntity = restTemplate.exchange("http://localhost:"+port+"/contactManagementSystem/contacts/{contactId}",
				                                                     HttpMethod.DELETE,
				                                                     null,
				                                                     Void.class,
				                                                     contactId);
		assertThat(ResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	public void testGetAllUsers() {
		
		ResponseEntity<List<Contact>> ResponseEntity = restTemplate.exchange("http://localhost:"+port+"/contactManagementSystem/contacts",
				                                                     HttpMethod.GET,
				                                                     null,
				                                                     new ParameterizedTypeReference<List<Contact>>() {
																	});
		assertThat(ResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<Contact> contacts = ResponseEntity.getBody();
		assertThat(contacts).isNotNull();
	}
}
