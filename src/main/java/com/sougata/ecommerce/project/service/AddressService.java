package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.User;
import com.sougata.ecommerce.project.payload.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getAddresses();

    AddressDTO findById(Long addressId);

    List<AddressDTO> getUserAddresses(User user);

    AddressDTO updateAddressById(Long addressId, AddressDTO addressDTO);

    void deleteCategory(Long addressId);
}
