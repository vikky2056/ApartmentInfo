package com.example.ApartmentInfo.Controller;

import com.example.ApartmentInfo.DTO.LeaseRequestDTO;
import com.example.ApartmentInfo.Model.LeaseDetails;
import com.example.ApartmentInfo.Service.LeaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaseDetailsController {
    @Autowired
    private LeaseDetailsService leaseDetailsService;

    @PostMapping("/createLeaseDetails")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public ResponseEntity<String> createLeaseDetails(@RequestBody LeaseRequestDTO leaseRequestDTO) {
        leaseDetailsService.createLease(leaseRequestDTO);
        return ResponseEntity.ok("Lease details created successfully.");
    }

}

//    @PostMapping("/savelease")
//    public LeaseDetails saveLeasedetails(@RequestBody LeaseDetails leaseDetails)
//    {
//        return leaseDetailsService.saveLeasedetails(leaseDetails);
//    }