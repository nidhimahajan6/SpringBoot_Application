package com.rev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rev.entity.Student;
import com.rev.entity.User;


//@RepositoryRestResource
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	/*@SuppressWarnings("unchecked")
	Student save(Student student);*/
	
	@Query("SELECT k FROM Student k WHERE k.id = :id")	
	List<Student> findById(@Param("id")  int id);
	
	
}


