package com.springboot.contact_manager.service;

import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.response.BaseResponse;

public interface ContactService {

    public BaseResponse createContact(ContactDTO request);
}
