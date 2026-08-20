package com.springboot.contact_manager.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(name = "name")
    public String name;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "email")
    public String email;

}
