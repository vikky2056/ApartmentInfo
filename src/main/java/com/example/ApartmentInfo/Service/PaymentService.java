package com.example.ApartmentInfo.Service;

import com.example.ApartmentInfo.DTO.PaymentRequestDTO;
import com.example.ApartmentInfo.Model.Payment;
import com.example.ApartmentInfo.Model.Property;
import com.example.ApartmentInfo.Model.Propertyuser;
import com.example.ApartmentInfo.Repository.PaymentRepo;
import com.example.ApartmentInfo.Repository.PropertyRepo;
import com.example.ApartmentInfo.Repository.PropertyUserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private PropertyUserRepo propertyUserRepo;
    @Transactional
    public void createPaymentDetails(PaymentRequestDTO paymentRequestDTO) {
        // Retrieve existing property by ID
      Property property=propertyRepo.findById(paymentRequestDTO.getPid()).orElseThrow(()-> new EntityNotFoundException("propertyid not found"));
Propertyuser propertyuser=propertyUserRepo.findById(paymentRequestDTO.getUid()).orElseThrow(()-> new EntityNotFoundException("propertyid not found"));
        // Create Payment
Payment payment=new Payment(paymentRequestDTO.getAmount(),paymentRequestDTO.getPaymentDate(),paymentRequestDTO.getMethod(),property,propertyuser);
        paymentRepo.save(payment);
    }


    public Payment savePayment(Payment payment){
      return   paymentRepo.save(payment);
    }
}
