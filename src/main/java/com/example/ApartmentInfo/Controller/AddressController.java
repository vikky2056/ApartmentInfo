package com.example.ApartmentInfo.Controller;

import com.example.ApartmentInfo.Model.Address;
import com.example.ApartmentInfo.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

   @PostMapping("/saveadrs")
   public Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }
}
