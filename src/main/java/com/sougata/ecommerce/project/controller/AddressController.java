package com.sougata.ecommerce.project.controller;

import com.sougata.ecommerce.project.model.Address;
import com.sougata.ecommerce.project.model.User;
import com.sougata.ecommerce.project.payload.AddressDTO;
import com.sougata.ecommerce.project.service.AddressService;
import com.sougata.ecommerce.project.utils.AuthUtil;
import com.sun.net.httpserver.HttpsServer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AuthUtil authUtil;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO) {

        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO, user);

        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAddresses(){

        List<AddressDTO> addressList = addressService.getAddresses();

        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@Valid @PathVariable Long addressId){

        AddressDTO address = addressService.findById(addressId);

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/user/addresses")
    public ResponseEntity<List<AddressDTO>> getUserAddresses(){

        User user = authUtil.loggedInUser();

        List<AddressDTO> addressList = addressService.getUserAddresses(user);

        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @PutMapping("addresses/{addressId}")
    public ResponseEntity<AddressDTO> updateAddressById(@PathVariable Long addressId, @RequestBody AddressDTO addressDTO){

        AddressDTO updartedAddress = addressService.updateAddressById(addressId, addressDTO);

        return new ResponseEntity<>(updartedAddress, HttpStatus.OK);
    }
}
