package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rev.entity.Student;

//@RepositoryRestResource
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@SuppressWarnings("unchecked")
	Student save(Student student);
	
	/*void delete(Student student);*/
}