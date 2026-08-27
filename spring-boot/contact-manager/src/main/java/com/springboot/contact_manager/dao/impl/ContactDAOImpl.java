package com.springboot.contact_manager.dao.impl;

import com.springboot.contact_manager.dao.ContactDAO;
import com.springboot.contact_manager.model.Contact;
import com.springboot.contact_manager.repository.ContactRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ContactDAOImpl implements ContactDAO {

    private final ContactRepository contactRepository;

    public ContactDAOImpl(ContactRepository repository) {
        this.contactRepository = repository;
    }

    public Contact add(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }


    public void deleteContact(UUID id) {
         contactRepository.deleteById(id);
    }

}
