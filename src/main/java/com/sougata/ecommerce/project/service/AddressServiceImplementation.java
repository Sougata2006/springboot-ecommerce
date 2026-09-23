package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.exceptions.ResourceNotFoundException;
import com.sougata.ecommerce.project.model.Address;
import com.sougata.ecommerce.project.model.User;
import com.sougata.ecommerce.project.payload.AddressDTO;
import com.sougata.ecommerce.project.repositories.AddressRepository;
import com.sougata.ecommerce.project.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;


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

    @Override
    public List<AddressDTO> getAddresses() {

        List<Address> addresses = addressRepository.findAll();

        return addresses.stream().map(address -> modelMapper.map(address, AddressDTO.class)).toList();
    }

    @Override
    public AddressDTO findById(Long addressId) {

        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

        AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);

        return addressDTO;
    }

    @Override
    public List<AddressDTO> getUserAddresses(User user) {

        List<Address> addresses = user.getAddresses();

        return addresses.stream().map(a -> modelMapper.map(a, AddressDTO.class)).toList();
    }

    @Override
    public AddressDTO updateAddressById(Long addressId, AddressDTO addressDTO) {

        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

        address.setBuildingName(addressDTO.getBuildingName());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setPinCode(addressDTO.getPinCode());
        address.setStreet(addressDTO.getStreet());
        address.setState(addressDTO.getState());

        Address updatedAddress = addressRepository.save(address);

        User user = address.getUser();
        user.getAddresses().removeIf(a -> address.getAddressId().equals(addressId));
        user.getAddresses().add(updatedAddress);
        userRepository.save(user);

        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public void deleteCategory(Long addressId) {

        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));

        User user = address.getUser();
        user.getAddresses().removeIf(a -> address.getAddressId().equals(addressId));
        userRepository.save(user);

        addressRepository.delete(address);
    }


}
