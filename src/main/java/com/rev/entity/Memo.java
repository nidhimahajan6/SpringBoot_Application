package com.rev.entity;



public class Memo  {


    public Memo(Student student, String supervisor, Project project) {
		this.student = student;
		this.supervisor = supervisor;
		this.project = project;
	}

	private Student student;
    
    
    private String supervisor;
  //  private List<Project>  projectList;
    
    public String getSupervisor() {
		return supervisor;
	}

	@Override
	public String toString() {
		return "Memo [student=" + student + ", supervisor=" + supervisor + ", project=" + project + "]";
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    
    
		

	
}
