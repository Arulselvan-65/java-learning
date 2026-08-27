package com.springboot.contact_manager.dto.response;

import com.springboot.contact_manager.dto.ContactDTO;
import lombok.Data;

import java.util.List;

@Data
public class ContactListResponse extends BaseResponse {

    private List<ContactDTO> contacts;

}
