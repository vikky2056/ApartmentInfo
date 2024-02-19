package com.example.ApartmentInfo.Repository;

import com.example.ApartmentInfo.Model.LeaseDetails;
import com.example.ApartmentInfo.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseDetailsRepo extends JpaRepository<LeaseDetails,Integer> {


}
