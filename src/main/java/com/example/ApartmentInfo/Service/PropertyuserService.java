package com.example.ApartmentInfo.Service;

import com.example.ApartmentInfo.DTO.PropertyRequestDTO;
import com.example.ApartmentInfo.Model.*;
import com.example.ApartmentInfo.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyuserService {

    private PropertyUserRepo propertyUserRepo;
    private AddressRepo addressRepo;
    private PropertyRepo propertyRepo;

   @Autowired
   public PropertyuserService(PropertyUserRepo propertyUserRepo,AddressRepo addressRepo,PropertyRepo propertyRepo){
        this.propertyRepo=propertyRepo;
        this.propertyUserRepo=propertyUserRepo;
        this.addressRepo=addressRepo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


  @Transactional
    public void createProperty(PropertyRequestDTO propertyRequestDTO) {
        // Create Address entity

        Address address=new Address(propertyRequestDTO.getAddress(), propertyRequestDTO.getCity(), propertyRequestDTO.getState(),propertyRequestDTO.getZipcode());
             addressRepo.save(address);

     Propertyuser owner=new Propertyuser(propertyRequestDTO.getUname(),propertyRequestDTO.getUphone(),propertyRequestDTO.getUemail(),passwordEncoder.encode(propertyRequestDTO.getPassword()),propertyRequestDTO.getRoles(),address);
        propertyUserRepo.save(owner);

      Property property=new Property(propertyRequestDTO.getType(),propertyRequestDTO.getPropertyprice(),owner,address);
      propertyRepo.save(property);
    }
}
