package com.example.ApartmentInfo.DTO;

import jakarta.persistence.Column;
import lombok.NonNull;

public class JwtRequest {

    private String uemail;


    private String password;

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
