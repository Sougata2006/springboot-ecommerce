package com.sougata.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must have 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must have 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 3, message = "City name must have 3 characters")
    private String city;

    @NotBlank
    @Size(min = 3, message = "State name must have 3 characters")
    private String state;

    @NotBlank
    @Size(min = 4, message = "Country name must have 5 characters")
    private String country;

    @NotBlank
    @Size(min = 6, message = "Pin code must have 5 characters")
    private String pinCode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String street, String buildingName, String city, String state, String country, String pinCode) {
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }
}
