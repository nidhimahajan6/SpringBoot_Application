package com.rev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.rev.dto.EmailDTO;
import com.rev.entity.Invoice;
import com.rev.entity.InvoiceDocumentImpl;
import com.rev.entity.Memo;
import com.rev.entity.MemoDocument;
import com.rev.entity.MemoDocumentImpl;
import com.rev.entity.Project;
import com.rev.entity.Student;
import com.rev.entity.User;
import com.rev.feed.DataFeeder;
import com.rev.feed.FeedContext;
import com.rev.feed.FeedProcessor;
import com.rev.feed.FeedReader;
import com.rev.feed.FeedReady;
import com.rev.feed.FeederTemplate;
import com.rev.feed.FeederToStart;
import com.rev.feed.StockFeeder;
import com.rev.feed.WeatherFeeder;
import com.rev.form.Post;
import com.rev.repository.StudentRepository;
import com.rev.service.EmailNotifier;
import com.rev.service.EmailNotifierImpl;
import com.rev.service.StudentService;
import com.rev.service.UserService;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

//import bin.financeEMFDemo.FinanceEMFDemoFactory;

import java.util.Collection;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    
    @Autowired
    private UserService userService;
    
   @Autowired
    private StudentRepository studentRepository;

 
   
   
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentById(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
    
    // Fetch records for  particular Project Code
    
    @RequestMapping(value = "/{name}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> fetchProjects(Model model,@PathVariable("id") int id,@PathVariable("name") String name){
    	long start = System.nanoTime();
    	List<User> listOfUsers = new LinkedList<>();
        
    	UserCallable userCallable = new UserCallable(name);
    	StudentCallable studentCallable = new StudentCallable(id);
    	UserCallable1 userCallable1 = new UserCallable1(id);
    	

    	//FutureTask<List<User>> futureTask1 = new FutureTask<List<User>>(userCallable);
    	FutureTask<List<User>> futureTask1 = new FutureTask<List<User>>(userCallable1);
    	FutureTask<List<Student>> futureTask2 = new FutureTask<List<Student>>(studentCallable);
    	
    	ExecutorService executor = Executors.newFixedThreadPool(1);
    	
    	executor.execute(futureTask1);
    	executor.execute(futureTask2);
    	while(true){
    		
    		if(futureTask1.isDone() && futureTask2.isDone()){
    			
    			System.out.println("user fetching done");
    			
    			System.out.println(" After fetching  the users list "+ (System.nanoTime()-start));
    	    	try {
					System.out.println(" User:List size is>>>>>>>> " +  futureTask1.get().size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
    	    	try {
					System.out.println(" Student : List size is>>>>>>>> " +  futureTask2.get().toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
    	    	executor.shutdown();
    	    	
    		}
    		
    		if(!futureTask1.isDone()){
				//wait indefinitely for future task to complete
				try {
					futureTask1.get();
					System.out.println("FutureTask1 output=>"+futureTask1.get().size());
					
					futureTask2.get();
					System.out.println("FutureTask2 output=>"+futureTask2.get().size());
					
					
				} catch (InterruptedException e) {
					System.out.println("FutureTask1 InterruptedException="+e.getMessage());
					e.printStackTrace();
				} catch (ExecutionException e) {
					System.out.println("FutureTask1 ExecutionException="+e.getMessage());
					e.printStackTrace();
				}
				}
    		
    		try {
				executor.awaitTermination(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return listOfUsers;
    	}
    }
    
    
    // User Task
     class UserCallable implements Callable<List<User>> {

    	private String name;
    	
    	List<User> listOfUsers = new LinkedList<>();
    	public UserCallable(String name){
    		this.name=name;
    		
    	}
    	@Override
    	public List<User> call() throws Exception {
    		//Thread.sleep(waitTime);
    		listOfUsers = userService.fetchUsers(this.name);
            return listOfUsers;
    	}

    }
     
     
     class UserCallable1 implements Callable<List<User>> {

     	private int id;
     	
     	List<User> listOfUsers = new LinkedList<>();
     	public UserCallable1(int id){
     		this.id=id;
     		
     	}
     	@Override
     	public List<User> call() throws Exception {
     		//Thread.sleep(waitTime);
     		listOfUsers = userService.fetchUsersById(this.id);
             return listOfUsers;
     	}

     }
     
     
     // Student Task
     class StudentCallable implements Callable<List<Student>> {

     	private long waitTime;
     	private int id;
     	
     	List<Student> listOfStudents = new LinkedList<>();
     	public StudentCallable(int id){
     		this.id=id;
     		
     	}
     	@Override
     	public List<Student> call() throws Exception {
     		//Thread.sleep(waitTime);
     		listOfStudents = studentService.findById(id);
             //return the thread name executing this callable task
             return listOfStudents;
     	}

     }
    
    //Create Memo Document for a Student into a Project
    
    @RequestMapping(value = "/createMemo",method = RequestMethod.POST)
    public String createMemo(@ModelAttribute("student")Student student){
    	System.out.println(" Inside craete Memo.. ");
    //	model.addAttribute("ProjectName", student.getProject());
    //	model.addAttribute("ProjectName", "Sample");
    	//model.addAttribute("StudentName", student.getName());
    	return "memoPage";
      //  studentService.insertStudent(student);
    }
    
    
 
    @RequestMapping(value = "/feeds/{feedType}",method = RequestMethod.GET)
    public String feedsForApp(Model model,@PathVariable("feedType") String feedType){
    	System.out.println(" Inside fetching feeds...... ");
	/**************************cal to stock template ***************/
   		if(feedType.equals("stock")){
   		FeederTemplate stockFeederTemplate = new StockFeeder();
   		
   		stockFeederTemplate.feedProcessor();
   		
   		}
   		
   		
   		/**************************cal to weather template ***************/
   		if(feedType.equals("weather")){
   		FeederTemplate weatherFeederTemplate = new WeatherFeeder();
   		
   		weatherFeederTemplate.feedProcessor();
   		}
    	return "memoPage";
      //  studentService.insertStudent(student);
    }
    
    
    
    
   /* @RequestMapping(value = "/", method = RequestMethod.POST)
	public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		model.addAttribute("title", post.getTitle());
		model.addAttribute("content", post.getContent());
		model.addAttribute("title", "Intern");
		model.addAttribute("content", "AI");
		
		return "result";
	}*/
    
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
   	public String addNewCase(@Valid Student student, BindingResult bindingResult, Model model) {
   		if (bindingResult.hasErrors()) {
   			return "index";
   		}
   		
   		/*
   		 * 
   		 * Test connection to DB using Spring Boot........
   		 */
   		
   		
   		Student student1 = new Student();
   		student1.setCourse("deep learning");
   		student1.setExpenses(12000);
   		Student std  = studentService.saveStudent(student1); // Test for persistence 
   		
   		studentRepository.save(std);
   		/*
   		 * Mockito test case1: to Mock the repository
   		 */
   		
   		System.out.println("After saving the student identity");
   		
   		Student st = studentService.getStudentById(2);
   		model.addAttribute("Name", st.getStudentname());
   		//model.addAttribute("Project", st.getProject());// commented for test
   		model.addAttribute("Course", st.getCourse()!=null?st.getCourse():"DummyCourse");
   		model.addAttribute("DistinctionCount", st.getDistinctionCount());
   	
   		/*
   		 * 
   		 * calling the Memo creation for the (a new case) for student
   		 */
   		
   		MemoDocument memoDocument = new MemoDocumentImpl();
   		
   		// Create Memo
   		Memo memo = new Memo(st, st.getSupervisor()!=null?st.getSupervisor():"DummySuperVisor", 
   				/*st.getProject()!=null?st.getProject():*/new Project()); // Values to be fetched from UI form using thymeLeaf
   		// These values kept dummy for time being 
   		memoDocument.addProject(memo, st);
   		memoDocument.addSupervisor(memo, st);
   		
   		model.addAttribute("Memo", memo); //// Add memo as object after building the Memo Object
   		
   		/*model.addAttribute("title", "Intern");
   		model.addAttribute("content", "AI");*/
   		
   		// Craete the Invoice with memo details + expenses( memo + expenses === Invoice)
   		
   		Student stu = st;
   		
   		MemoDocument invoiceDocument = new InvoiceDocumentImpl(memoDocument);
   		
   		invoiceDocument.addProject(memo, stu);
   		invoiceDocument.addSupervisor(memo, st);
   		
   		//Invoice invoice = new Invoice();
   		
   	
   		model.addAttribute("studentInvoice", stu);

   		return "caseAddition";
   	} 
    
    
    
}