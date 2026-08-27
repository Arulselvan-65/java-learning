package com.springboot.contact_manager.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.contact_manager.dto.ContactDTO;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactResponse extends BaseResponse {

    private UUID id;
    private ContactDTO contact;

}
