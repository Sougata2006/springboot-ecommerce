package com.sougata.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(max = 20)
    private String userName;

    @NotBlank
    @Size(max = 25)
    @Email
    @UniqueElements
    private String email;

    @NotBlank
    @Size(min = 5, max = 50)
    private String password;


    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
}
