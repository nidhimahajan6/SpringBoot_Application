package com.rev.helper;

import com.rev.entity.Student;
import com.rev.utility.Builder;
import com.rev.utility.StudentBuilder;

public class StudentHelper {
	
	Builder builder;
	
	
	public void setStudentBuilder(Builder studentBuilder){
		builder = studentBuilder;
	}
	
	public Student getStudent(){
		return builder.getStudent();
	}
	
	public void createStudent(){
		builder.createStudent();
		builder.addExpenses();
		builder.distinctions();
	}

}
