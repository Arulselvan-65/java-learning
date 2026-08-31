package com.springboot.contact_manager.repository;

import com.springboot.contact_manager.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    boolean existsById(UUID id);

    boolean existsByName(String name);

    boolean existsByPhoneNumber(String number);

    @Query(value = "SELECT c FROM Contact c WHERE c.name LIKE CONCAT('%',:name,'%') ORDER BY c.name")
    List<Contact> search(@Param("name") String name);
}
