package com.example.ApartmentInfo.Controller;

import com.example.ApartmentInfo.DTO.PaymentRequestDTO;
import com.example.ApartmentInfo.Model.Payment;
import com.example.ApartmentInfo.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/createPayment")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public ResponseEntity<String> createPaymentDetails(@RequestBody PaymentRequestDTO paymentRequestDTO, Authentication authentication) {
        paymentService.createPaymentDetails(paymentRequestDTO);
        return ResponseEntity.ok("Payment details created successfully.");
    }

    @PostMapping("savepay")
  public Payment savePayment(@RequestBody Payment payment){
        return   paymentService.savePayment(payment);
    }
}

