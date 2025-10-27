package com.smart_housing.smart_housing.model;



import com.smart_housing.smart_housing.model.Property;
import com.smart_housing.smart_housing.model.PropertyType;
import com.smart_housing.smart_housing.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public/properties")
@CrossOrigin(origins = {"http://127.0.0.1:8080", "http://localhost:8080"})
public class PublicPropertyController {

    private final PropertyService propertyService;

    public PublicPropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Get all properties (for students to browse)
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.getAllPublicProperties();
        return ResponseEntity.ok(properties);
    }

    // Get properties by type (e.g., SINGLE_ROOM, BEDSITTER)
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Property>> getPropertiesByType(@PathVariable PropertyType type) {
        List<Property> properties = propertyService.getPropertiesByType(type);
        return ResponseEntity.ok(properties);
    }

    // Get single property details
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(property);
    }

    // Search properties by location
    @GetMapping("/search")
    public ResponseEntity<List<Property>> searchProperties(@RequestParam String location) {
        List<Property> properties = propertyService.searchByLocation(location);
        return ResponseEntity.ok(properties);
    }
}
