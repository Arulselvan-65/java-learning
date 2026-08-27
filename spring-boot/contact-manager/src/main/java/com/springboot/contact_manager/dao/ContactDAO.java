package com.springboot.contact_manager.dao;

import com.springboot.contact_manager.dto.response.ContactListResponse;
import com.springboot.contact_manager.model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactDAO {

    Contact add(Contact contact);

    List<Contact> getContacts();

    void deleteContact(UUID id);

}
