package com.smart_housing.smart_housing.repository;

import com.smart_housing.smart_housing.model.Houses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository  extends JpaRepository<Houses, Long> {

}


