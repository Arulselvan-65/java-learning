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
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactDAO contactDAO;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;
    private final ContactValidator contactValidator;

    public ContactServiceImpl(ContactDAO contactDAO, RequestMapper requestMapper, ContactValidator contactValidator,
                              ResponseMapper responseMapper) {
        this.contactDAO = contactDAO;
        this.requestMapper = requestMapper;
        this.contactValidator = contactValidator;
        this.responseMapper = responseMapper;
    }

    public ContactListResponse search(String name,boolean isDesc) {
        if(CommonUtil.checkIsNullOrEmpty(name)) {
            throw new IllegalArgumentException("Enter a valid name");
        }
        ContactListResponse response = new ContactListResponse();
        StatusDetail statusDetail = new StatusDetail();
        List<Contact> contacts = contactDAO.findByNameContaining(name, isDesc);
        if(!CommonUtil.checkIsNullOrEmpty(contacts)) {
            List<ContactDTO> res = responseMapper.convertContact(contacts);
            response.setContacts(res);
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


    public ContactResponse createContact(ContactDTO request) {
        ContactResponse response = new ContactResponse();
        StatusDetail statusDetail = new StatusDetail();
        contactValidator.validate(request);
        Contact contact = requestMapper.buildContact(request);
        contact = contactDAO.save(contact);
        response.setId(contact.getId());
        response.setStatus(StatusConstants.CREATED);
        statusDetail.setCode(StatusConstants.CREATED);
        statusDetail.setMessage(MessageConstants.CREATED);
        response.setStatusDetail(statusDetail);
        return response;
    }

    public ContactResponse getContact(UUID id) {
        ContactResponse response = new ContactResponse();
        StatusDetail statusDetail = new StatusDetail();
        Contact contact = contactDAO.getContact(id);
        if(!CommonUtil.checkIsNullOrEmpty(contact)) {
            response.setContact(responseMapper.convert(contact));
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

    public ContactListResponse getContacts() {
        ContactListResponse response = new ContactListResponse();
        StatusDetail statusDetail = new StatusDetail();
        List<Contact> contacts = contactDAO.getContacts();
        List<ContactDTO> result = responseMapper.convert(contacts);
        response.setContacts(result);
        response.setStatus(StatusConstants.SUCCESS);
        statusDetail.setCode(StatusConstants.SUCCESS);
        statusDetail.setMessage(MessageConstants.SUCCESS);
        response.setStatusDetail(statusDetail);
        return response;
    }

    public BaseResponse updateContact(UUID id, ContactDTO request) {
        BaseResponse response = new BaseResponse();
        StatusDetail statusDetail = new StatusDetail();
        Contact contact = contactDAO.getContact(id);
        if(!CommonUtil.checkIsNullOrEmpty(contact)) {
            updateFields(contact, request);
            contactDAO.save(contact);
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

    public BaseResponse deleteContact(UUID id) {
        BaseResponse response = new BaseResponse();
        StatusDetail statusDetail = new StatusDetail();
        if(!contactDAO.existsById(id)) {
            response.setStatus(StatusConstants.NOT_FOUND);
            statusDetail.setCode(StatusConstants.NOT_FOUND);
            statusDetail.setMessage(MessageConstants.NOT_FOUND);
            response.setStatusDetail(statusDetail);
            return response;
        }
        contactDAO.deleteContact(id);
        response.setStatus(StatusConstants.SUCCESS);
        statusDetail.setCode(StatusConstants.SUCCESS);
        statusDetail.setMessage(MessageConstants.SUCCESS);
        response.setStatusDetail(statusDetail);
        return response;
    }

    private void updateFields(Contact contact, ContactDTO request) {
        if(!CommonUtil.checkIsNullOrEmpty(request.getName())) {
            if(!contactDAO.existsByNameAndIdNot(request.getName(), contact.getId()))
                contact.setName(request.getName());
            else throw new IllegalArgumentException("Name already exists");
        }
        if(!CommonUtil.checkIsNullOrEmpty(request.getEmail())) {
            if(!request.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
                throw new IllegalArgumentException("Enter a valid email");
            else
                contact.setEmail(request.getEmail());
        }
        if(!CommonUtil.checkIsNullOrEmpty(request.getPhoneNumber())) {
            if(!request.getPhoneNumber().matches("^\\+\\d{2} [6-9]\\d{9}$"))
                throw new IllegalArgumentException("Enter a valid phone number");
            if(!contactDAO.existsByPhoneNumberAndIdNot(request.getPhoneNumber(), contact.getId()))
                contact.setPhoneNumber(request.getPhoneNumber());
            else throw new IllegalArgumentException("Phone Number already exists");
        }
    }

}


