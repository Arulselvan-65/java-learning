package com.springboot.contact_manager.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ContactDTO {

    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;

}
