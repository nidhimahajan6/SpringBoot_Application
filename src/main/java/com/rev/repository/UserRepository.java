package com.rev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rev.entity.Student;
import com.rev.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// User fetchUsers(String name);
	@Query("SELECT p FROM User p WHERE p.preferredname = :preferredname")	
	List<User> findByPreferredname(@Param("preferredname")  String preferredname);

}
