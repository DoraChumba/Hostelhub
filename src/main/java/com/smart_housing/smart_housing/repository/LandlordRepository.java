package com.smart_housing.smart_housing.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smart_housing.smart_housing.model.Landlord;

public interface LandlordRepository extends JpaRepository<Landlord, Long> {
    
}
