package com.springboot.contact_manager.validator;

import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.utils.CommonUtil;
import org.springframework.stereotype.Component;

@Component
public class ContactValidator {


    public void validate(ContactDTO request) {
        if(CommonUtil.checkIsNullOrEmpty(request.getName())) {
            throw new IllegalArgumentException("Enter a valid name");
        }
    }
}
