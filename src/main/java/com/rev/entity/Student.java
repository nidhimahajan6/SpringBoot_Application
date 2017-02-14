package com.rev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
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