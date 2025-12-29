package com.example.ContactManagement.controller;

import com.example.ContactManagement.model.Contact;
import com.example.ContactManagement.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin("*")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    // ADD
    @PostMapping
    public Contact add(@RequestBody Contact c) {
        return service.save(c);
    }

    // GET ALL
    @GetMapping
    public List<Contact> getAll() {
        return service.getAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Contact update(@PathVariable int id, @RequestBody Contact c) {
        return service.update(id, c);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    // 🔍 SEARCH (NAME OR PHONE)
    @GetMapping("/search")
    public List<Contact> search(@RequestParam("q") String q) {

        // pehle name se search
        List<Contact> byName = service.searchByName(q);

        // agar name se mila to wahi return
        if (!byName.isEmpty()) {
            return byName;
        }

        // warna phone se search
        return service.searchByPhone(q);
    }
}
