package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.User;
import com.sougata.ecommerce.project.payload.AddressDTO;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);
}
