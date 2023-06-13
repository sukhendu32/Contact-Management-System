package com.example.assignment.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.demo.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	
	Optional<Contact> findByphoneNumber(String phoneNumber);

}
