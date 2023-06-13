package com.example.assignment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.assignment.demo.exception.ContactException;
import com.example.assignment.demo.model.Contact;
import com.example.assignment.demo.service.ContactServiceImpl;

@RestController
@RequestMapping("/contactManagementSystem")
public class ContactController {

	@Autowired
	private ContactServiceImpl contactService;
	
	@PostMapping("/register")
	public String registerContact(@RequestBody Contact contact) throws ContactException{
	   
		return contactService.registerContact(contact); 	
	}
	
	@GetExchange("/contacts")
	public List<Contact> getAllContact(){
		
		return contactService.getAllContacts();
	}
	
	@DeleteMapping("/contacts/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) throws ContactException {
		
		return contactService.deleteContact(contactId);
	}
}
