package com.rev.entity;

import com.rev.utility.InvoiceDecorator;

public class InvoiceDocumentImpl extends InvoiceDecorator{

	public InvoiceDocumentImpl(MemoDocument document) {
		super(document);
	}
	
	
	@Override
	public void addProject(Memo memo,Student student) {
		super.addProject(memo, student);
		
		
		
	}

	@Override
	public void addSupervisor(Memo memo,Student student) {
	//	super.addSupervisor(memo, student);
		student.setExpenses(1000); // Added to decorate the existing Memo Object with expenses beared or a student
		student.setDistinctionCount(7);
		
		
	}
	
	

}
