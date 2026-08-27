package com.springboot.contact_manager.service.impl;

import com.springboot.contact_manager.constants.MessageConstants;
import com.springboot.contact_manager.constants.StatusConstants;
import com.springboot.contact_manager.dao.ContactDAO;
import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.StatusDetail;
import com.springboot.contact_manager.dto.response.BaseResponse;
import com.springboot.contact_manager.dto.response.ContactListResponse;
import com.springboot.contact_manager.dto.response.ContactResponse;
import com.springboot.contact_manager.mapper.RequestMapper;
import com.springboot.contact_manager.mapper.ResponseMapper;
import com.springboot.contact_manager.model.Contact;
import com.springboot.contact_manager.service.ContactService;
import com.springboot.contact_manager.validator.ContactValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;
    private RequestMapper requestMapper;
    private ResponseMapper responseMapper;
    private ContactValidator contactValidator;
    private StatusDetail statusDetail = new StatusDetail();

    @Autowired
    public ContactServiceImpl(ContactDAO contactDAO, RequestMapper requestMapper, ContactValidator contactValidator,
                              ResponseMapper responseMapper) {
        this.contactDAO = contactDAO;
        this.requestMapper = requestMapper;
        this.contactValidator = contactValidator;
        this.responseMapper = responseMapper;
    }

    public ContactResponse createContact(ContactDTO request) {
        ContactResponse response = new ContactResponse();
        contactValidator.validate(request);
        Contact contact = requestMapper.buildContact(request);
        contact = contactDAO.add(contact);
        response.setId(contact.getId());
        response.setStatus(StatusConstants.CREATED);
        statusDetail.setCode(StatusConstants.CREATED);
        statusDetail.setMessage(MessageConstants.CREATED);
        response.setStatusDetail(statusDetail);
        return response;
    }

    public ContactListResponse getAllContacts() {
        ContactListResponse response = new ContactListResponse();
        List<Contact> contacts = contactDAO.getContacts();
        List<ContactDTO> result = responseMapper.convert(contacts);
        response.setContacts(result);
        response.setStatus(StatusConstants.SUCCESS);
        statusDetail.setCode(StatusConstants.SUCCESS);
        statusDetail.setMessage(MessageConstants.SUCCESS);
        response.setStatusDetail(statusDetail);
        return response;
    }

    public BaseResponse deleteContact(UUID id) {
        BaseResponse response = new BaseResponse();
        contactDAO.deleteContact(id);
        response.setStatus(StatusConstants.SUCCESS);
        statusDetail.setCode(StatusConstants.SUCCESS);
        statusDetail.setMessage(MessageConstants.SUCCESS);
        response.setStatusDetail(statusDetail);
        return response;
    }

}


