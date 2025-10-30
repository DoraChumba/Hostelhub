package com.smart_housing.smart_housing.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.smart_housing.smart_housing.model.Landlord;
import com.smart_housing.smart_housing.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LandlordService {
    @Autowired
    private LandlordRepository landlordRepository;

    public String register(Landlord landlord) {
        if (landlordRepository.findByEmail(landlord.getEmail()).isPresent()) {
            return "Email already exists!";
        }
        landlordRepository.save(landlord);
        return "Landlord registered successfully!";
    }

    public String login(String email, String password) {
        var landlordOpt = landlordRepository.findByEmail(email);
        if (landlordOpt.isEmpty()) {
            return "Email not found!";
        }
        Landlord landlord = landlordOpt.get();
        if (!landlord.getPassword().equals(password)) {
            return "Incorrect password!";
        }
        return "Login successful!";
    }
}
