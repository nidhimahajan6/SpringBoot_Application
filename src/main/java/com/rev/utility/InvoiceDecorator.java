package com.rev.utility;

import com.rev.entity.Memo;
import com.rev.entity.MemoDocument;
import com.rev.entity.Student;

/*
 * 
 *  New Decorator : New Class that has all implementations for Memo Document
 */
public class InvoiceDecorator  implements MemoDocument{

	
	private MemoDocument document;
	
	public InvoiceDecorator(MemoDocument document) {
		this.document = document;
	}

	
	
	public void addProject(Memo memo, Student student) {
		document.addProject(memo, student);
		
	}

	public void addSupervisor(Memo memo, Student student) {
		document.addSupervisor(memo, student);
		
	}

}
