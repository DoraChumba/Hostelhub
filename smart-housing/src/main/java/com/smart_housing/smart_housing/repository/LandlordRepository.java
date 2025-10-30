package com.smart_housing.smart_housing.repository;

import com.smart_housing.smart_housing.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Integer> {
    Optional<Landlord> findByEmail(String email);
}
