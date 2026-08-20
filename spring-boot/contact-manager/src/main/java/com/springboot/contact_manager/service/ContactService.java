package com.springboot.contact_manager.service;

import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.response.BaseResponse;

public interface ContactService {

    BaseResponse createContact(ContactDTO request);
}
