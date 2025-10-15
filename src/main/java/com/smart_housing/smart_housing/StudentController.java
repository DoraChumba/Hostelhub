package com.smart_housing.smart_housing;
import org.springframework.web.bind.annotation.*;
import com.smart_housing.smart_housing.model.Student;
import com.smart_housing.smart_housing.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")



public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Register student
    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        return service.registerStudent(student);
    }

    // Login student
    @PostMapping("/login")
    public String login(@RequestBody Student student) {
        boolean success = service.loginStudent(student.getEmail(), student.getPassword());
        return success ? "Login successful" : "Invalid credentials";
    }
}
