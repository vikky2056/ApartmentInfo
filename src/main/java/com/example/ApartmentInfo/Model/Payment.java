package com.example.ApartmentInfo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private double amount;

    private Date paymentDate;

    private String method;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id", referencedColumnName = "pid")
    private Property property;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propertyuser_id", referencedColumnName = "uid")
    private Propertyuser propertyuser;



    public Payment( double amount, Date paymentDate,  String method,Property property,Propertyuser propertyuser) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
        this.property=property;
        this.propertyuser=propertyuser;


    }


}
//