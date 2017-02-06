package com.rev.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.rev.entity.Student;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudentToDb(Student student);
    
    // Added for executor Services
    String getStudentRecordsById(int id);
    
    
    Student insertStudentById(int id,String name);
    
}