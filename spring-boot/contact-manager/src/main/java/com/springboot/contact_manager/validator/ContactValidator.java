package com.springboot.contact_manager.validator;

import com.springboot.contact_manager.dao.ContactDAO;
import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.utils.CommonUtil;
import org.springframework.stereotype.Component;

@Component
public class ContactValidator {


    private final ContactDAO contactDAO;

    public ContactValidator(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public void validate(ContactDTO request) {
        if(CommonUtil.checkIsNullOrEmpty(request.getName())) {
            throw new IllegalArgumentException("Enter a valid name");
        }
        if(CommonUtil.checkIsNullOrEmpty(request.getPhoneNumber()) || !request.getPhoneNumber().matches("^\\+\\d{2} [6-9]\\d{9}$")) {
            throw new IllegalArgumentException("Enter a valid phone number");
        }
        if(contactDAO.existsByName(request.getName())) {
            throw new IllegalArgumentException("Name already exists");
        }
    }
}
