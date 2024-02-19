package com.example.ApartmentInfo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


public class PropertyRequestDTO {

    private String uname;
   private String uphone;
    private String uemail;
    private String password;
    private String roles;



    private String type;
    private double propertyprice;


   private String address;
  private String city;
  private String state;



    private String zipcode;

    public PropertyRequestDTO(String uname, String uphone, String uemail, String password, String type, double propertyprice, String address, String owner, String city, String state, String zipcode) {
        this.uname = uname;
        this.uphone = uphone;
        this.uemail = uemail;
        this.password = password;
        this.roles=roles;
        this.type = type;
        this.propertyprice = propertyprice;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPropertyprice() {
        return propertyprice;
    }

    public void setPropertyprice(double propertyprice) {
        this.propertyprice = propertyprice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
