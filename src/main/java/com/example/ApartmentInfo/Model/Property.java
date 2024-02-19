package com.example.ApartmentInfo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Property {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int pid;

   private String type;


    @NonNull
   private double propertyprice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner", referencedColumnName = "uid")
    private Propertyuser owner;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addId")
    private Address address;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
   private List<LeaseDetails> leaseDetails;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Payment> payments;

    public Property(String type,  double propertyprice, Propertyuser owner, Address address) {
        this.type = type;
        this.propertyprice = propertyprice;
        this.address = address;
        this.owner = owner;
    }


}



//    @OneToMany(mappedBy = "property", cascade = CascadeType.PERSIST)
//    private List<Propertyuser> propertyuser;
//
//
//




//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userid",referencedColumnName = "uid")
//     private Propertyuser propertyuser;


//    @Enumerated(EnumType.STRING)
//    private UserType type;
//    public enum UserType {
//        LANDLORD,
//        TENANT
//    }