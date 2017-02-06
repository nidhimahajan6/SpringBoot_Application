package com.rev.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String course;
    
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", distinctionCount=" + distinctionCount
				+ ", expenses=" + expenses + "]";
	}

	private long expenses; 

    public int getDistinctionCount() {
		return distinctionCount;
	}

	public void setDistinctionCount(int distinctionCount) {
		this.distinctionCount = distinctionCount;
	}

	

	public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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