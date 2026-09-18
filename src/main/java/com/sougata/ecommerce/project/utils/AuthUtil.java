package com.sougata.ecommerce.project.utils;


import com.sougata.ecommerce.project.model.User;
import com.sougata.ecommerce.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

    @Autowired
    private UserRepository userRepository;

    public String loggedInEmail(){
        return loggedInUser().getEmail();
    }

    public Long loggedInUserId(){
        return loggedInUser().getUserId();
    }

    public User loggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found with username : "+authentication.getName()));

        return user;
    }
}
