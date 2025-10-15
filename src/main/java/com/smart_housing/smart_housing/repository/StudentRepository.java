package com.smart_housing.smart_housing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smart_housing.smart_housing.model.Student;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
