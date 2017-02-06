package com.rev.utility;

import java.io.IOException;

public class RecordReader implements Runnable{
	
	RecordUtility recordUtility;

	public RecordReader(RecordUtility recordUtility) {
		super();
		this.recordUtility = recordUtility;
	}

	//Read the records for student
	public void run() {

		synchronized (this.recordUtility) {
		
		try {
			recordUtility.readStudentRecords();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(" error is " + e.getMessage());
		}
		
		}
	}

}
