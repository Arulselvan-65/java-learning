package com.springboot.contact_manager.dao;

import com.springboot.contact_manager.model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactDAO {

    List<Contact> findByNameContaining(String name, boolean isDesc);

    Contact save(Contact contact);

    Contact getContact(UUID id);

    List<Contact> getContacts();

    boolean existsById(UUID id);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, UUID id);

    boolean existsByPhoneNumberAndIdNot(String number, UUID id);

    boolean existsByPhoneNumber(String number);

    void deleteContact(UUID id);

}
