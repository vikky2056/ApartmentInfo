package com.example.ApartmentInfo.Service;

import com.example.ApartmentInfo.DTO.LeaseRequestDTO;
import com.example.ApartmentInfo.Model.LeaseDetails;
import com.example.ApartmentInfo.Model.Property;
import com.example.ApartmentInfo.Model.Propertyuser;
import com.example.ApartmentInfo.Repository.AddressRepo;
import com.example.ApartmentInfo.Repository.LeaseDetailsRepo;
import com.example.ApartmentInfo.Repository.PropertyRepo;
import com.example.ApartmentInfo.Repository.PropertyUserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.coyote.http11.Constants.a;

@Service
public class LeaseDetailsService {

    private final LeaseDetailsRepo leaseDetailsRepo;

    private PropertyUserRepo propertyUserRepo;
    private AddressRepo addressRepo;
    private PropertyRepo propertyRepo;


   @Autowired
   public LeaseDetailsService(LeaseDetailsRepo leaseDetailsRepo,PropertyUserRepo propertyUserRepo,PropertyRepo propertyRepo) {
        this.leaseDetailsRepo = leaseDetailsRepo;
        this.propertyUserRepo = propertyUserRepo;
        this.propertyRepo=propertyRepo;
    }


    @Transactional
    public void createLease(LeaseRequestDTO leaseRequestDTO) {
        Property property=propertyRepo.findById(leaseRequestDTO.getPid()).orElseThrow();


        Propertyuser propertyuser;
        if (leaseRequestDTO.getUid() > 0) {
            propertyuser = propertyUserRepo.findById(leaseRequestDTO.getUid())
                    .orElseThrow(() -> new EntityNotFoundException("Propertyuser not found"));
        } else {
            propertyuser = new Propertyuser(
                    leaseRequestDTO.getUname(),
                    leaseRequestDTO.getUphone(),
                    leaseRequestDTO.getUemail(),
                    leaseRequestDTO.getPassword(),
                    leaseRequestDTO.getRoles(),
                    property.getAddress()
            );
            propertyUserRepo.save(propertyuser);
        }

        LeaseDetails leaseDetails=new LeaseDetails(leaseRequestDTO.getRent(),
        leaseRequestDTO.getStartdate(), leaseRequestDTO.getEnddate(),property,propertyuser);
leaseDetailsRepo.save(leaseDetails);
}}