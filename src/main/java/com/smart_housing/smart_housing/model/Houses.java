package com.smart_housing.smart_housing.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="houses")

public class Houses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     // foreign key
    @ManyToOne
    @JoinColumn(name ="landlord_Id", referencedColumnName="landlord_Id")
    private Landlord landlord_Id;

    private String location;
    private BigDecimal rent;
    private String amenities;

    @Enumerated(EnumType.STRING)
    private HousesType image;

    private String image_path;

     @Enumerated(EnumType.STRING)
    private HousesStatus status;

     private LocalDateTime created_at= LocalDateTime.now();

     //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    public Landlord getLandlord_Id() {
        return landlord_Id;
    }
    public void setlandlord_Id(Landlord landlord_Id) {this.landlord_Id = landlord_Id;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public BigDecimal getRent() {return rent;}
public void setRent(BigDecimal rent){this.rent =rent;}

public String getAmenities(){return amenities;}
public void setAmenities(String amenities){this.amenities=amenities;}

public HousesType getImage(){return image;}
public void setImage(HousesType image){this.image= image;}

public String getImage_path(){return image_path;}
public void setImage_path(String image_path){this.image_path=image_path;}

public HousesStatus getStatus(){return status;}
public void setStatus(HousesStatus status){this.status=status;}

public LocalDateTime getCreated_at() {return created_at;}
public void setCreated_at(LocalDateTime created_at){this.created_at=created_at;}
}





