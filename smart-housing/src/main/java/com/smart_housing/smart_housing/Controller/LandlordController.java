package com.smart_housing.smart_housing.Controller;

import com.smart_housing.smart_housing.model.Landlord;
import com.smart_housing.smart_housing.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://127.0.0.1:8080", "http://localhost:8080"})

@RestController
@RequestMapping("/api/landlords")


public class LandlordController {
    @Autowired
    private LandlordService landlordService;

    @PostMapping("/register")
    public String register(@RequestBody Landlord landlord) {
        return landlordService.register(landlord);
    }

    @PostMapping("/login")
    public String login(@RequestBody Landlord landlord) {
        return landlordService.login(landlord.getEmail(), landlord.getPassword());
    }

}
