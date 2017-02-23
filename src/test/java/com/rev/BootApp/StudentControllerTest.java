package com.rev.BootApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.rev.controller.StudentController;
import com.rev.entity.Student;
import com.rev.entity.User;
import com.rev.repository.StudentRepository;
import com.rev.repository.UserRepository;
import com.rev.service.StudentService;
import com.rev.utility.StudentBuilder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertFalse;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest{
	
	
	@Mock
	StudentService studentService;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	Student student;
	
	List<User> lst = new ArrayList<>();
	
	@Test
	public void test(){
		//Student st = new Student();
		/*when(studentRepository.save(student)).thenReturn(student);
		when(studentRepository.findById(8)).thenReturn(lst);
		
		assertEquals(1, studentRepository.findById(8).size());*/
		
		when(userRepository.findByPreferredname("pappu")).thenReturn(lst);
		//assertEquals(2113, userRepository.findByPreferredname("pappu").size());
		
		StudentService studentService = mock(StudentService.class);
		Student st = studentService.getStudentById(2);
		
		verify(studentService, Mockito.times(1));
		
		/*StudentRepository studentRepository = mock(StudentRepository.class);
		StudentService studentService = mock(StudentService.class);
		//Student st = studentService.getStudentById(2);
		Student st = new Student();
		st.setStudentname("AkhilTest");
		when(studentRepository.save(st)).thenReturn(st);
		assertEquals("AkhilTest", st.getStudentname());*/
		
	}
}

