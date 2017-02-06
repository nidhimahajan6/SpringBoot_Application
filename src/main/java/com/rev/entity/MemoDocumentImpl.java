package com.rev.entity;



public class MemoDocumentImpl implements MemoDocument{
	
	//List<Student> studentsPerDoc = new ArrayList<>();
	
	//Memo memo;

	public void addProject(Memo memo,Student student) {
	//	memo.setProject(student.getProject());
		
		
		
	}

	public void addSupervisor(Memo memo,Student student) {
		memo.setSupervisor(student.getSupervisor()!=null?student.getSupervisor():"dUMMY");
		
	}

}
