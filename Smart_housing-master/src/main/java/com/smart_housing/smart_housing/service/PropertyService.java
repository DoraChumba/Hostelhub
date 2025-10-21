package com.smart_housing.smart_housing.service;



import com.smart_housing.smart_housing.dto.PropertyRequest;
import com.smart_housing.smart_housing.model.Property;
import com.smart_housing.smart_housing.model.PropertyStatus;
import com.smart_housing.smart_housing.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllPropertiesByLandlord(Long landlordId) {
        return propertyRepository.findByLandlordId(landlordId);
    }

    public Property getPropertyByIdAndLandlord(Long id, Long landlordId) {
        return propertyRepository.findById(id)
                .filter(p -> p.getLandlordId().equals(landlordId))
                .orElseThrow(() -> new NoSuchElementException("Property not found or access denied"));
    }

    @Transactional
    public Property createProperty(PropertyRequest request, Long landlordId) {
        Property property = new Property();
        property.setLandlordId(landlordId);
        property.setName(request.getName());
        property.setLocation(request.getLocation());
        property.setType(request.getType());
        property.setMaxOccupancy(request.getMaxOccupancy());
        property.setDescription(request.getDescription());
        property.setPrice(request.getPrice());
        property.setSecurityDetails(request.getSecurityDetails());
        property.setAmenities(request.getAmenities());
        property.setImages(request.getImages());
        property.setStatus(request.getStatus() != null ? request.getStatus() : PropertyStatus.VACANT);
        return propertyRepository.save(property);
    }

    @Transactional
    public Property updateProperty(Long id, PropertyRequest request, Long landlordId) {
        Property property = getPropertyByIdAndLandlord(id, landlordId);
        property.setName(request.getName());
        property.setLocation(request.getLocation());
        property.setType(request.getType());
        property.setMaxOccupancy(request.getMaxOccupancy());
        property.setDescription(request.getDescription());
        property.setPrice(request.getPrice());
        property.setSecurityDetails(request.getSecurityDetails());
        property.setAmenities(request.getAmenities());
        property.setImages(request.getImages());
        property.setStatus(request.getStatus());
        return propertyRepository.save(property);
    }

    @Transactional
    public void deleteProperty(Long id, Long landlordId) {
        if (!propertyRepository.existsByIdAndLandlordId(id, landlordId)) {
            throw new NoSuchElementException("Property not found or access denied");
        }
        propertyRepository.deleteById(id);
    }
}