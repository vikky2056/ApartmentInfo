package com.example.ApartmentInfo.Controller;

import com.example.ApartmentInfo.DTO.JwtRequest;
import com.example.ApartmentInfo.DTO.PropertyRequestDTO;
import com.example.ApartmentInfo.Model.Propertyuser;
import com.example.ApartmentInfo.Repository.PropertyUserRepo;
import com.example.ApartmentInfo.Service.PropertyuserService;
import com.example.ApartmentInfo.Utils.JwtUtil;
import com.example.ApartmentInfo.config.PropertyuserUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PropertyuserController {

    @Autowired private PropertyuserService propertyuserService;


    @Autowired private AuthenticationManager authenticationManager;


    @Autowired private JwtUtil jwtUtil;

   @Autowired private PropertyUserRepo propertyUserRepo;





//    @Autowired
//    public PropertyuserController(PropertyuserService propertyuserService, AuthenticationManager authenticationManager, JwtUtil jwtUtil,UserDetailsService userDetailsService) {
//        this.propertyuserService = propertyuserService;
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService=userDetailsService;
//    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/create")
    public ResponseEntity<String> createProperty(@RequestBody PropertyRequestDTO propertyRequestDTO) {
        propertyuserService.createProperty(propertyRequestDTO);
        return ResponseEntity.ok("Property, owner, and address created successfully."+propertyRequestDTO);

    }


//@PostMapping("/authenticate")
//    public String createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//
//    Authentication authentication = authenticationManager.authenticate(new  UsernamePasswordAuthenticationToken(jwtRequest.getUemail(), jwtRequest.getPassword()));
//   if (authentication.isAuthenticated()) {
//        return jwtUtil.generateToken(jwtRequest.getUemail());
//
//           }
//    else {
//        throw new UsernameNotFoundException("invalid user request !");
//    }




    @CrossOrigin(origins = "http://localhost:202/jan2022/login")
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUemail(), jwtRequest.getPassword()));
            String token = jwtUtil.generateToken(jwtRequest.getUemail());

            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user request!");
        }
    }

}






//    @PostMapping("")
//    public ResponseEntity<Map<String, String>> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
////        try {
////            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(jwtRequest.getUemail(), jwtRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUemail());
//        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
//
//        Map<String, String> response = new HashMap<>();
//        response.put("jwt", jwt);
//
//        return ResponseEntity.ok(response);
//    }

//    @GetMapping("/propertyuser")
//    public Propertyuser saveUser(@RequestBody Propertyuser propertyuser){
//        return propertyuserService.c(propertyuser);
//    }