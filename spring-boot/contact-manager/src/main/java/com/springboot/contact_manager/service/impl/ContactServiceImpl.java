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
import com.springboot.contact_manager.utils.CommonUtil;
import com.springboot.contact_manager.validator.ContactValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactDAO contactDAO;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;
    private final ContactValidator contactValidator;
    private final StatusDetail statusDetail;

    public ContactServiceImpl(ContactDAO contactDAO, RequestMapper requestMapper, ContactValidator contactValidator,
                              ResponseMapper responseMapper) {
        this.contactDAO = contactDAO;
        this.requestMapper = requestMapper;
        this.contactValidator = contactValidator;
        this.responseMapper = responseMapper;
        this.statusDetail = new StatusDetail();
    }

    public ContactListResponse search(String name) {
        if(CommonUtil.checkIsNullOrEmpty(name)) {
            throw new IllegalArgumentException("Enter a valid name");
        }
        ContactListResponse response = new ContactListResponse();
        List<Contact> contacts = contactDAO.search(name);
        List<ContactDTO> res = responseMapper.convertContact(contacts);
        response.setContacts(res);
        response.setStatus(StatusConstants.SUCCESS);
        statusDetail.setCode(StatusConstants.SUCCESS);
        statusDetail.setMessage(MessageConstants.SUCCESS);
        response.setStatusDetail(statusDetail);
        return response;
    }


    public ContactResponse createContact(ContactDTO request) {
        ContactResponse response = new ContactResponse();
        contactValidator.validate(request);
        Contact contact = requestMapper.buildContact(request);
        contact = contactDAO.addContact(contact);
        response.setId(contact.getId());
        response.setStatus(StatusConstants.CREATED);
        statusDetail.setCode(StatusConstants.CREATED);
        statusDetail.setMessage(MessageConstants.CREATED);
        response.setStatusDetail(statusDetail);
        return response;
    }

    public ContactResponse getContact(UUID id) {
        ContactResponse response = new ContactResponse();
        Optional<Contact> contact = contactDAO.getContact(id);
        if(contact.isPresent()) {
            response.setContact(requestMapper.convert(contact.get()));
            response.setStatus(StatusConstants.SUCCESS);
            statusDetail.setCode(StatusConstants.SUCCESS);
            statusDetail.setMessage(MessageConstants.SUCCESS);
            response.setStatusDetail(statusDetail);
            return response;
        }
        response.setStatus(StatusConstants.NOT_FOUND);
        statusDetail.setCode(StatusConstants.NOT_FOUND);
        statusDetail.setMessage(MessageConstants.NOT_FOUND);
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


