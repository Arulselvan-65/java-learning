package com.springboot.contact_manager.mapper;

import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.model.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseMapper {

    public List<ContactDTO> convert(List<Contact> contacts) {
        List<ContactDTO> res = new ArrayList<>();
        for(Contact c : contacts) {
            res.add(ContactDTO.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .phoneNumber(c.getPhoneNumber())
                    .email(c.getEmail())
                    .build()
            );
        }
        return res;
    }

    public List<ContactDTO> convertContact(List<Contact> contacts) {
        List<ContactDTO> res = new ArrayList<>();
        for(Contact c : contacts) {
            res.add(ContactDTO.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .build()
            );
        }
        return res;
    }
}
