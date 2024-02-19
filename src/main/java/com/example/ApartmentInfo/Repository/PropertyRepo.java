package com.example.ApartmentInfo.Repository;

import com.example.ApartmentInfo.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface PropertyRepo extends JpaRepository<Property,Integer>
{


}
