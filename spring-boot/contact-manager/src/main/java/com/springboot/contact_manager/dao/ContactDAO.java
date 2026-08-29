package com.springboot.contact_manager.dao;

import com.springboot.contact_manager.model.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactDAO {

    List<Contact> search(String name);

    Contact addContact(Contact contact);

    Optional<Contact> getContact(UUID id);

    List<Contact> getContacts();

    boolean existsById(UUID id);

    boolean existsByName(String name);

    void deleteContact(UUID id);

}
