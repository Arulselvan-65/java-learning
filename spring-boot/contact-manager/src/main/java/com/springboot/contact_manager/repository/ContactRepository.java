package com.springboot.contact_manager.repository;

import com.springboot.contact_manager.model.Contact;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    boolean existsById(UUID id);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, UUID id);

    boolean existsByPhoneNumber(String number);

    boolean existsByPhoneNumberAndIdNot(String number, UUID id);

    List<Contact> findByNameContaining(String name, Sort sort);

}
