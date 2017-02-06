package com.rev.entity;

public class Invoice {

	
	private Student student;
    
	private Project project;
    
    public Invoice(Student student, Project project, String supervisor) {
		super();
		this.student = student;
		this.project = project;
		this.supervisor = supervisor;
	}
    
    
    @Override
	public String toString() {
		return "Invoice [student=" + student + ", project=" + project + ", supervisor=" + supervisor + "]";
	}


	public Invoice(){
    	
    }

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	private String supervisor;
    
    
}
