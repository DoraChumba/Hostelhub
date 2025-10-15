package com.smart_housing.smart_housing;
import org.springframework.stereotype.Service;
import com.smart_housing.smart_housing.repository.StudentRepository;
import com.smart_housing.smart_housing.model.Student;
import java.util.Optional;

@Service

public class StudentService {
    public final StudentRepository repo;

    public StudentService(StudentRepository repo) {
    this.repo = repo;
    }
    public Student registerStudent(Student student) {
        return repo.save(student);
    }
   public boolean loginStudent(String email, String password) {
        Optional<Student> found = repo.findByEmail(email);
        return found.isPresent() && found.get().getPassword().equals(password);
    }
}
