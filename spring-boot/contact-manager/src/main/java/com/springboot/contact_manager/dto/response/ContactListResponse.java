package com.springboot.contact_manager.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.contact_manager.dto.ContactDTO;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactListResponse extends BaseResponse {

    private List<ContactDTO> contacts;

}
