package com.example.ApartmentInfo.config;

import com.example.ApartmentInfo.Model.Propertyuser;
import com.example.ApartmentInfo.Repository.PropertyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class PropertyuserUserDetailsService implements UserDetailsService {
   @Autowired
      private PropertyUserRepo propertyUserRepo;



    @Override
    public UserDetails loadUserByUsername(String uemail) throws UsernameNotFoundException {
        Optional<Propertyuser> propertyuser = propertyUserRepo.findByUemail(uemail);
        return propertyuser.map(PropertyuserUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + uemail));

    }


}
