package com.rev.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RecordUtility {
	
	BlockingQueue<String>  queue = new LinkedBlockingQueue<String>();
	
	StringBuffer sb = new StringBuffer();
	
	public String readStudentRecords() throws IOException{
		
	BufferedReader br = null;
	String buffer = null;
	try {
		//br = new BufferedReader(new FileReader(new File("C:\\Software_Personal\\textSample.txt")));
		
		br = new BufferedReader(new FileReader(new File("C:\\Software_Personal\\textSample.txt")));
		
		
		try {
			while ((buffer=br.readLine())!=null) {
				
				try {
					queue.put(buffer);
					//Thread.sleep(200);
					sb.append(buffer);
					System.out.println(buffer);
				//	System.out.println(" Added in queue " + queue.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		br.close();
	}
	return sb.toString();
	}

}
