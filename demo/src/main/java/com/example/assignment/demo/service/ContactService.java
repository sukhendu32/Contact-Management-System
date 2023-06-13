package com.example.assignment.demo.service;

import java.util.List;

import com.example.assignment.demo.model.Contact;

public interface ContactService {
	
	
	public String registerContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public String deleteContact(Integer contactId);

}
