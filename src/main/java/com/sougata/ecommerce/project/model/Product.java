package com.sougata.ecommerce.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String ProductName;
    private String Description;
    private Integer Quantity;
    private double Price;
    private double SpecialPrice;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
