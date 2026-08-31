package com.springboot.contact_manager.dao.impl;

import com.springboot.contact_manager.dao.ContactDAO;
import com.springboot.contact_manager.model.Contact;
import com.springboot.contact_manager.repository.ContactRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ContactDAOImpl implements ContactDAO {

    private final ContactRepository contactRepository;

    public ContactDAOImpl(ContactRepository repository) {
        this.contactRepository = repository;
    }

    public List<Contact> findByNameContaining(String name, boolean isDesc) {
        return contactRepository.findByNameContaining(name,
                isDesc ? Sort.by(Sort.Direction.DESC, "name")
                : Sort.by(Sort.Direction.ASC, "name"));
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public Contact getContact(UUID id) {
        return contactRepository.findById(id).orElse(null);
    }

    public boolean existsById(UUID id) {
        return contactRepository.existsById(id);
    }

    public boolean existsByPhoneNumber(String number) {
        return contactRepository.existsByPhoneNumber(number);
    }

    public boolean existsByPhoneNumberAndIdNot(String number, UUID id) {
        return contactRepository.existsByPhoneNumberAndIdNot(number, id);
    }

    public boolean existsByName(String name) {
        return contactRepository.existsByName(name);
    }

    public boolean existsByNameAndIdNot(String name, UUID id) {
        return contactRepository.existsByNameAndIdNot(name,id);
    }

    public void deleteContact(UUID id) {
         contactRepository.deleteById(id);
    }

}
