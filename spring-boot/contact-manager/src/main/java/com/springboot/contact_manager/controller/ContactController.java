package com.springboot.contact_manager.controller;

import com.springboot.contact_manager.constants.EndpointConstants;
import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.response.BaseResponse;
import com.springboot.contact_manager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping(EndpointConstants.CREATE_CONTACT)
    public ResponseEntity<BaseResponse> createContact(@RequestBody ContactDTO request) {
        BaseResponse response = contactService.createContact(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
