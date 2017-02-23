package com.rev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student"/*,schema="ikare"*/)
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   

  // private Project project; 
	
	public int getId() {
	return id;
}


/*public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}
*/

public void setId(int id) {
	this.id = id;
}


	


	public Student(int id, String studentname, String course) {
	super();
	this.id = id;
	this.studentname = studentname;
	this.course = course;
}


	public Student(int id, String studentname, String course, int distinctionCount, String supervisor, long expenses) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.course = course;
		this.distinctionCount = distinctionCount;
		this.supervisor = supervisor;
		this.expenses = expenses;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}


	

	 @Column(name="studentname")
	private String studentname;
	 
	 @Column(name="course")
    private String course;
    
    @Column(name="distinctioncount")
    private int distinctionCount;
    
   // private Project project;
    @Column(name="supervisor")
    private String supervisor;
    
    
	public String getSupervisor() {
		return supervisor;
	}


	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	
/*    public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
*/
	public long getExpenses() {
		return expenses;
	}

	public void setExpenses(long expenses) {
		this.expenses = expenses;
	}

	
	@Column(name="expenses")
	private long expenses; 

    public int getDistinctionCount() {
		return distinctionCount;
	}

	public void setDistinctionCount(int distinctionCount) {
		this.distinctionCount = distinctionCount;
	}

	

	
   

   

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String name) {
        this.studentname = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}