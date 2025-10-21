package com.smart_housing.smart_housing.Controller;



import com.smart_housing.smart_housing.dto.PropertyRequest;
import com.smart_housing.smart_housing.model.Property;
import com.smart_housing.smart_housing.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/landlord")
@CrossOrigin(origins = {"http://127.0.0.1:8080", "http://localhost:8080"})
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Helper to get landlordId from header (temporary)
    private Long getLandlordIdFromHeader(@RequestHeader("X-Landlord-Id") Long landlordId) {
        return landlordId;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAllProperties(@RequestHeader("X-Landlord-Id") Long landlordId) {
        List<Property> properties = propertyService.getAllPropertiesByLandlord(landlordId);
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity<Property> getProperty(
            @PathVariable Long id,
            @RequestHeader("X-Landlord-Id") Long landlordId) {
        Property property = propertyService.getPropertyByIdAndLandlord(id, landlordId);
        return ResponseEntity.ok(property);
    }

    @PostMapping("/properties")
    public ResponseEntity<Property> createProperty(
            @Valid @RequestBody PropertyRequest request,
            @RequestHeader("X-Landlord-Id") Long landlordId) {
        Property saved = propertyService.createProperty(request, landlordId);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<Property> updateProperty(
            @PathVariable Long id,
            @Valid @RequestBody PropertyRequest request,
            @RequestHeader("X-Landlord-Id") Long landlordId) {
        Property updated = propertyService.updateProperty(id, request, landlordId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> deleteProperty(
            @PathVariable Long id,
            @RequestHeader("X-Landlord-Id") Long landlordId) {
        propertyService.deleteProperty(id, landlordId);
        return ResponseEntity.noContent().build();
    }
}