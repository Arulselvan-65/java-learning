package com.springboot.contact_manager.service.impl;

import com.springboot.contact_manager.constants.MessageConstants;
import com.springboot.contact_manager.constants.StatusConstants;
import com.springboot.contact_manager.dao.ContactDAO;
import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.StatusDetail;
import com.springboot.contact_manager.dto.response.BaseResponse;
import com.springboot.contact_manager.mapper.RequestMapper;
import com.springboot.contact_manager.model.Contact;
import com.springboot.contact_manager.service.ContactService;
import com.springboot.contact_manager.validator.ContactValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;
    private RequestMapper requestMapper;
    private ContactValidator contactValidator;
    private StatusDetail statusDetails = new StatusDetail();

    @Autowired
    public ContactServiceImpl(ContactDAO contactDAO, RequestMapper requestMapper, ContactValidator contactValidator) {
        this.contactDAO = contactDAO;
        this.requestMapper = requestMapper;
        this.contactValidator = contactValidator;
    }

    public BaseResponse createContact(ContactDTO request) {
        BaseResponse response = new BaseResponse();
        contactValidator.validate(request);
        Contact contact = requestMapper.buildContact(request);
        contactDAO.add(contact);
        response.setStatus(StatusConstants.CREATED);
        statusDetails.setCode(StatusConstants.CREATED);
        statusDetails.setMessage(MessageConstants.CREATED);
        response.setStatusDetail(statusDetails);
        return response;
    }
}


