package com.example.ApartmentInfo.Service;

import com.example.ApartmentInfo.Model.Address;
import com.example.ApartmentInfo.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
   @Autowired
      private AddressRepo addressRepo;


    public Address saveAddress(Address address){
        return addressRepo.save(address);
    }

}
