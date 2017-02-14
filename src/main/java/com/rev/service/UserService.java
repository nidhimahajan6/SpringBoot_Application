package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.dao.StudentDao;
import com.rev.entity.Student;
import com.rev.entity.User;
import com.rev.repository.StudentRepository;
import com.rev.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;

	@Autowired
	    public void setUserRepository(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

   
   
   public List<User> fetchUsers(String name,int limit,int offSet){
   	//StudentRepository studentRepository = new StudentRepositoryImpl();
   	return this.userRepository.findByPreferredname(name);
   }

}
