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
        if(CommonUtil.checkIsNullOrEmpty(request.getEmail()) || !request.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Enter a valid email");
        }
        if(contactDAO.existsByName(request.getName())) {
            throw new IllegalArgumentException("Name already exists");
        }
        if(contactDAO.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone Number already exists");
        }
    }
}
