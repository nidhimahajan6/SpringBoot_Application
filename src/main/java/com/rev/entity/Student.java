package com.rev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student",schema="ikare")
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


	


	public Student(int id, String name, String course) {
	super();
	this.id = id;
	this.name = name;
	this.course = course;
}


	public Student(int id, String name, String course, int distinctionCount, String supervisor, long expenses) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.distinctionCount = distinctionCount;
		this.supervisor = supervisor;
		this.expenses = expenses;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}


	


	private String name;
    private String course;
    
    @Column(name="distinctioncount")
    private int distinctionCount;
    
   // private Project project;
    
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

	

	private long expenses; 

    public int getDistinctionCount() {
		return distinctionCount;
	}

	public void setDistinctionCount(int distinctionCount) {
		this.distinctionCount = distinctionCount;
	}

	

	
   

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}