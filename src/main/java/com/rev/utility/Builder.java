package com.rev.utility;

import com.rev.entity.Student;

public abstract class Builder {
	
	Student student;
	
	
	public Student getStudent(){
		return student;
	}
	
	public void createStudent(){
		student = new Student();
	}
	
	public abstract void  addExpenses();
	
	public abstract void distinctions();

}
