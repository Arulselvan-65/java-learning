package com.springboot.contact_manager.service;

import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.response.BaseResponse;
import com.springboot.contact_manager.dto.response.ContactListResponse;
import com.springboot.contact_manager.dto.response.ContactResponse;

import java.util.UUID;

public interface ContactService {

    ContactListResponse search(String name);

    ContactResponse createContact(ContactDTO request);

    ContactResponse getContact(UUID id);

    ContactListResponse getContacts();

    BaseResponse updateContact(UUID id, ContactDTO request);

    BaseResponse deleteContact(UUID id);

}
