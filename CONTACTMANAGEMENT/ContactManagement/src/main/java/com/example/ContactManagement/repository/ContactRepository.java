package com.example.ContactManagement.repository;

import com.example.ContactManagement.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByNameContainingIgnoreCase(String name);

    List<Contact> findByPhoneContaining(String phone);
}
