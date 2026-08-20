package com.springboot.contact_manager.service.impl;

import com.springboot.contact_manager.constants.MessageConstants;
import com.springboot.contact_manager.constants.StatusConstants;
import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.StatusDetail;
import com.springboot.contact_manager.dto.response.BaseResponse;
import com.springboot.contact_manager.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    public StatusDetail statusDetails = new StatusDetail();

    public BaseResponse createContact(ContactDTO request) {
        BaseResponse response = new BaseResponse();
        response.setStatus(StatusConstants.CREATED);
        statusDetails.setCode(StatusConstants.CREATED);
        statusDetails.setMessage(MessageConstants.CREATED);
        response.setStatusDetail(statusDetails);
        return response;
    }
}


