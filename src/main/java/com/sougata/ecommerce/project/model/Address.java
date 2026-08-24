package com.sougata.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long addressId;

}
