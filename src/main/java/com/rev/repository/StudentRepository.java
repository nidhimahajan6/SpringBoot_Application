package com.rev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rev.entity.Student;


//@RepositoryRestResource
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@SuppressWarnings("unchecked")
	Student save(Student student);
	
	@Query("SELECT k FROM student k WHERE k.user_id = :user_id")	
	List<Student> findByuser_id(@Param("user_id")  int user_id);
	
	
}