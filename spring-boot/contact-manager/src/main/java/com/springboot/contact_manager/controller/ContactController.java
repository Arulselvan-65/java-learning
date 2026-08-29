package com.springboot.contact_manager.controller;

import com.springboot.contact_manager.constants.EndpointConstants;
import com.springboot.contact_manager.dto.ContactDTO;
import com.springboot.contact_manager.dto.response.BaseResponse;
import com.springboot.contact_manager.dto.response.ContactListResponse;
import com.springboot.contact_manager.dto.response.ContactResponse;
import com.springboot.contact_manager.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(EndpointConstants.SEARCH)
    public ResponseEntity<ContactListResponse> search(@RequestParam("name") String name) {
        ContactListResponse response = contactService.search(name);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @PostMapping(EndpointConstants.CREATE_CONTACT)
    public ResponseEntity<ContactResponse> createContact(@RequestBody ContactDTO request) {
        ContactResponse response = contactService.createContact(request);
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @GetMapping(EndpointConstants.GET_CONTACT)
    public ResponseEntity<ContactResponse> getContact(@PathVariable("id") UUID id) {
        ContactResponse response = contactService.getContact(id);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @GetMapping(EndpointConstants.GET_CONTACTS)
    public ResponseEntity<ContactListResponse> getAllContacts() {
        ContactListResponse response = contactService.getContacts();

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @PatchMapping(EndpointConstants.UPDATE_CONTACT)
    public ResponseEntity<BaseResponse> updateContact(@PathVariable("id") UUID id) {
        BaseResponse response = contactService.updateContact(id);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @DeleteMapping(EndpointConstants.DELETE_CONTACT)
    public ResponseEntity<BaseResponse> deleteContact(@PathVariable("id") UUID id) {
        BaseResponse response = contactService.deleteContact(id);
        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

}
