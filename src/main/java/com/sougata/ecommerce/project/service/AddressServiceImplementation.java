package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.Address;
import com.sougata.ecommerce.project.model.User;
import com.sougata.ecommerce.project.payload.AddressDTO;
import com.sougata.ecommerce.project.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {

        Address address = modelMapper.map(addressDTO, Address.class);

        List<Address> addressList = user.getAddresses();
        addressList.add(address);

        user.setAddresses(addressList);

        address.setUser(user);
        Address savedAddress = addressRepository.save(address);

        return modelMapper.map(savedAddress, AddressDTO.class);
    }
}
