package com.example.ApartmentInfo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addId;
    private String address;
    private String city;
     private String state;
     private String zipcode;


    public Address(String address, String city, String state, String zipcode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}



//    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
//    private Propertyuser propertyUser;
//
//    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
//    private Property property;