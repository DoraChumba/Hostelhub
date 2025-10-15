package com.smart_housing.smart_housing.model;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String Name;
    private String email;
    private String password;
    private Long phoneNumber;

    //GETTERS AND SETTERS
    public long getStudent_Id() {return studentId;}

    public void setStudent_Id(Long student_Id) {
        this.studentId = studentId;
    }
    public String getName() {return Name;}
    public void setName(String name) {this.Name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Long getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(Long phoneNumber) {this.phoneNumber = phoneNumber;}
}