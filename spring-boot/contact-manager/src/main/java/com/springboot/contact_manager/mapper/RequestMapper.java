package com.springboot.contact_manager.mapper;

import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.model.Contact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RequestMapper {

    public Contact buildContact(ContactDTO request) {
        return Contact.builder()
                .id(request.getId())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .build();
    }
}
