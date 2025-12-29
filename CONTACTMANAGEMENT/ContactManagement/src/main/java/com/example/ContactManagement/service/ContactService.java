package com.example.ContactManagement.service;

import com.example.ContactManagement.model.Contact;
import com.example.ContactManagement.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repo;

    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public Contact save(Contact c) {
        return repo.save(c);
    }

    public List<Contact> getAll() {
        return repo.findAll();
    }

    public Contact update(int id, Contact c) {
        Contact old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setName(c.getName());
            old.setPhone(c.getPhone());
            return repo.save(old);
        }
        return null;
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<Contact> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<Contact> searchByPhone(String phone) {
        return repo.findByPhoneContaining(phone);
    }
}
