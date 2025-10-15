package com.smart_housing.smart_housing.model;
import jakarta.persistence.*;
 import java.time.LocalDateTime;

@Entity
@Table(name="upload_files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="studentId", referencedColumnName="studentId")
    private Student studentId;

    @Enumerated(EnumType.STRING)
    private FileType doc_type;
    private String file_path;
    private LocalDateTime upload_time= LocalDateTime.now();

    //Getters and Setters
public Long getId() {return id;}
public void setId(Long id) {this.id = id;}      
public Student getStudentId() {return studentId;}
public void setStudentId(Student studentId) {this.studentId = studentId;}
public FileType getDoc_type() {return doc_type;}
public void setDoc_type(FileType doc_type) {this.doc_type = doc_type;}
public String getFile_path() {return file_path;}
public void setFile_path(String file_path) {this.file_path = file_path;}
public LocalDateTime getUpload_time() {return upload_time;}
public void setUpload_time(LocalDateTime upload_time) {this.upload_time = upload_time;}
    
}