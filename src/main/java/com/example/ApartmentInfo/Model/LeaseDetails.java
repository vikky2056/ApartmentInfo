package com.example.ApartmentInfo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class LeaseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaseId;
   @NonNull
   private double rent;
    @NonNull private Date startdate;
   @NonNull private Date enddate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id",nullable = false)
    private Property property;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_user_id")
    private Propertyuser propertyuser;

    public LeaseDetails(@NonNull double rent, @NonNull Date startdate, @NonNull Date enddate, Property property, Propertyuser propertyuser) {

        this.rent = rent;
        this.startdate = startdate;
        this.enddate = enddate;
        this.property = property;
        this.propertyuser = propertyuser;
    }
}
//    @OneToMany(mappedBy = "leaseDetails", cascade = CascadeType.ALL)
//    private List<Payment> payments;