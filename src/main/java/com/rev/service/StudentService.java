package com.rev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rev.dao.StudentDao;
import com.rev.entity.Student;
import com.rev.entity.User;
import com.rev.repository.StudentRepository;
//import com.rev.repository.StudentRepositoryImpl;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
	
	@Autowired
	 private StudentRepository studentRepository;

	@Autowired
	    public void setStudentRepository(StudentRepository studentRepository) {
	        this.studentRepository = studentRepository;
	    }

    @Autowired
   // @Qualifier("fakeData")
    private StudentDao studentDao;
    
    
    

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
    }


    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudentToDb(student);
    }
    
    
    
    
    // Get student record by ExecutorServices
    
    public String getStudentRecordsById(int id){
        return this.studentDao.getStudentRecordsById(id);
    }
    
    
    // insert student by id : using Builder Pattern
    
    public Student insertStudentById(int id,String name) {
        return this.studentDao.insertStudentById(id,name);
    }
    
    
    
    public Student saveStudent(Student student){
    	//StudentRepository studentRepository = new StudentRepositoryImpl();
    	return this.studentRepository.save(student);
    }
    
    

    public List<Student> findById(int id){
       	//StudentRepository studentRepository = new StudentRepositoryImpl();
       	return this.studentRepository.findById(id);
       }
    
    
    
    
}