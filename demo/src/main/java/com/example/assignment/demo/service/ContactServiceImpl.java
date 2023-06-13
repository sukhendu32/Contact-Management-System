package com.example.assignment.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.demo.model.Contact;
import com.example.assignment.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String registerContact(Contact contact) {
		
		 String number = contact.getPhoneNumber();
	     Optional<Contact> numberExist = contactRepo.findByphoneNumber(number);
	       
	       if(!numberExist.isPresent()) {
	    	   contactRepo.save(contact);
	    	   
	    	   return "Contact registered secessfully!";
	       }
	       
	       return "Contact not registered, please provide a unique Phone number";
	}

	@Override
	public List<Contact> getAllContacts() {

		return contactRepo.findAll();
	}

	@Override
	public String deleteContact(Integer contactId) {
		
		Optional<Contact> contact =  contactRepo.findById(contactId);
		
		if(contact.isPresent()) {
			contactRepo.delete(contact.get());
			
			return "contact deleted secessfully!";
		}
		
		return "please provide a valid contactId";
	}
}
