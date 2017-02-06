package com.rev.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rev.entity.Student;
import com.rev.helper.StudentHelper;
import com.rev.utility.RecordReader;
import com.rev.utility.RecordUtility;
import com.rev.utility.StudentBuilder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;

    
    
    
    
    static {

        students = new HashMap<Integer, Student>(){

            {
                put(1, new Student(1, "Said", "Computer Science"));
                put(2, new Student(2, "Alex U", "Finance"));
                put(3, new Student(3, "Anna", "Maths"));
            }
        };
    }

    
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    
    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(), student);
    }

    public Student insertStudentById(int id,String name) {
    	Student st = createStudent();
        this.students.put(id, st );
        return st;
    } 
    
    
    /*
     * 
     * 
     * Utility method to call/create  student Object
     */
    public Student createStudent(){
    	StudentHelper studentHelper = new StudentHelper();
    	studentHelper.setStudentBuilder(new StudentBuilder());
    	
    	studentHelper.createStudent();
    	
    	return studentHelper.getStudent();
    	
    }
    
    
    /*
     * 
     * (non-Javadoc)
     * @see com.rev.dao.StudentDao#getStudentRecordsById(int)
     * 
     * 
     * STATISTICS FOR DIFFERENT POOLS
     * 
     55591442013 : cached

50429864062 : fixed : 1

51995622586 : fixed : 10

55429886056 : cachePool

57136278979 : Fixd with processors available as number of threads
     */
    
    
    
    public String getStudentRecordsById(int records){
    	
    //	ExecutorService executorService = Executors.newFixedThreadPool(10);
    //	ExecutorService executorService = Executors.newCachedThreadPool();
    	//System.out.println(" Number of processors >>> " + executorService.getClass());
    	ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    	
    	long start = 0;
    	long end = 0;
    	start = System.nanoTime();
    	System.out.println(" start =>  " + start);
    	
    	System.out.println("Active thread are " + Thread.activeCount());
    	
    	RecordReader reader = new RecordReader(new RecordUtility());
    	
    	for(int i=0;i<10;i++){
    		
    		
    		executorService.execute(reader);
    		/*if(i==9){
    			
    		}*/
    	}
    	
    //	long end = System.nanoTime();
    	//System.out.println(" end =>  " + end);
    //	System.out.println(" end =>  " + System.nanoTime());
    	
    	
    	executorService.shutdown();
    	
    	try{
    	executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(executorService.isShutdown()){
    	 end = System.nanoTime();
	    	System.out.println(" end =>  " + end);
    	System.out.println(" Time Elapsed  =>  " + (end - start));
    	}
    	return "";
    }

}