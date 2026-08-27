package com.springboot.contact_manager.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDTO {

    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;

}
