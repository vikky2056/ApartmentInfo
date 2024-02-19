package com.example.ApartmentInfo.Service;

import com.example.ApartmentInfo.Model.Property;
import com.example.ApartmentInfo.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
@Autowired
private PropertyRepo propertyRepo;




    public Property saveProperty( Property property)
    {

        return propertyRepo.save(property);
    }


    public Property getPropertyById(int pid){
        return propertyRepo.findById(pid).orElse(null);
    }

    public List<Property> getAllProperty(){
return propertyRepo.findAll();
    }




}
