package com.springboot.contact_manager.service;

import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.response.BaseResponse;
import com.springboot.contact_manager.dto.response.ContactListResponse;
import com.springboot.contact_manager.dto.response.ContactResponse;

import java.util.UUID;

public interface ContactService {

    ContactResponse createContact(ContactDTO request);

    BaseResponse deleteContact(UUID id);

    ContactListResponse getAllContacts();

}
