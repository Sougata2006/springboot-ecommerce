package com.sougata.ecommerce.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {
    @GetMapping("/hello")
    public String hello() {
        return "Hello E-commerce ";
    }
}