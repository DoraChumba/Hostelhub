package com.smart_housing.smart_housing.model;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="landlords")
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long landlord_Id;
    private String Name;
    private String email;
    private String password;

    //GETTERS AND SETTERS
    public long getLandlord_Id() {return landlord_Id;}

    public void setLandlord_Id(Long landlord_Id) {
        this.landlord_Id = landlord_Id;
    }
    public String getName() {return Name;}
    public void setName(String name) {this.Name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}

