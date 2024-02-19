package com.example.ApartmentInfo.Controller;

import com.example.ApartmentInfo.Model.Propertyuser;
import com.example.ApartmentInfo.Model.Property;
import com.example.ApartmentInfo.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;


    @GetMapping("/hello")
    public String hello(){
        return "welcome to springboot";
    }

    @PostMapping("/property")
    public Property saveProperty(@RequestBody Property property){

        return propertyService.saveProperty(property);
}

@GetMapping("/property/id/{id}")
    public Property getPropertyById(@PathVariable("id") int pid){
        return propertyService.getPropertyById(pid);
}


@GetMapping("/property/all")
public List<Property> getAllProperty(){
        return propertyService.getAllProperty();
}

}
