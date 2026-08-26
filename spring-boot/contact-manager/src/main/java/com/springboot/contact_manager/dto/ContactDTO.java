package com.springboot.contact_manager.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactDTO {

    public UUID id;
    public String name;
    public String phoneNumber;
    public String email;

}
