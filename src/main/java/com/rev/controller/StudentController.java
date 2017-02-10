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
import com.rev.feed.DataFeeder;
import com.rev.feed.FeedContext;
import com.rev.feed.FeedProcessor;
import com.rev.feed.FeedReader;
import com.rev.feed.FeedReady;
import com.rev.feed.FeederToStart;
import com.rev.form.Post;
import com.rev.repository.StudentRepository;
import com.rev.service.EmailNotifier;
import com.rev.service.EmailNotifierImpl;
import com.rev.service.StudentService;

//import bin.financeEMFDemo.FinanceEMFDemoFactory;

import java.util.Collection;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
   @Autowired
    private StudentRepository studentRepository;

 //   
  //  private ProductService productService;

   
  // FinanceEMFDemoFactory factory = FinanceEMFDemoFactory.eINSTANCE;
   
   
   
   
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
    
    //1. Test for Executor Service
   /* @RequestMapping(value = "/{records}", method = RequestMethod.GET)
    public void getStudentRecordsById(@PathVariable("id") int id){
        studentService.getStudentRecordsById(id);
    }*/
    
    
    //1. Test for Executor Service
    
    @RequestMapping(value = "/{name}/{id}", method = RequestMethod.GET)
//    public String insertStudentById(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name){
    public String insertStudentById(Model model,@PathVariable("id") int id, @PathVariable("name") String name){
    	Student st = studentService.insertStudentById(id,name);
    	model.addAttribute("student",st);
    	return "students";
       // return st;
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
   		
   		
   	//	studentService.setProductRepository(studentRepository);
   		// studentService = new StudentService();
   		/*Student student1 = new Student();
   		student1.setCourse("Machine learning");
   		student1.setExpenses(2000);
   		Student std  = studentService.saveStudent(student1); // Test for persistence 
   		
   		
   		
   	//	studentRepository.save(new Student());
   		studentRepository.save(student1);
   		
   		System.out.println("After saving the student identity");
   		
   		Student st = studentService.getStudentById(2);
   		model.addAttribute("Name", st.getName());
   		//model.addAttribute("Project", st.getProject());// commented for test
   		model.addAttribute("Course", st.getCourse()!=null?st.getCourse():"DummyCourse");
   		model.addAttribute("DistinctionCount", st.getDistinctionCount());
   	
   		/*
   		 * 
   		 * calling the Memo creation for the (a new case) for student
   		 */
   		
   	//	MemoDocument memoDocument = new MemoDocumentImpl();
   		
   		// Create Memo
   	/*	Memo memo = new Memo(st, st.getSupervisor()!=null?st.getSupervisor():"DummySuperVisor", 
   				st.getProject()!=null?st.getProject():new Project());*/ // Values to be fetched from UI form using thymeLeaf
   		// These values kept dummy for time being 
   	/*	Memo memo = null;
   		memoDocument.addProject(memo, st);
   		memoDocument.addSupervisor(memo, st);
   		
   		model.addAttribute("Memo", memo); //// Add memo as object after building the Memo Object
   		
   		/*model.addAttribute("title", "Intern");
   		model.addAttribute("content", "AI");*/
   		
   		// Craete the Invoice with memo details + expenses
   		
   		/*Student stu = st;
   		
   		MemoDocument invoiceDocument = new InvoiceDocumentImpl(memoDocument);
   		
   	/*	invoiceDocument.addProject(memo, stu);
   		invoiceDocument.addSupervisor(memo, st);
   		
   		//Invoice invoice = new Invoice();
   		
   	
   		model.addAttribute("studentInvoice", stu);
   		*/
   		/*** STATE PATTERN ***************/
   		//Test for state Design Pattern
   		
   	//	synchronized (StudentController.class) {
   		FeedContext context = new FeedContext();
   		
   		//DataFeeder initialState = new FeederToStart(context);
   		
   		/*context.feedStatus();
   		context.feedStateCheck();*/
   		
   		
   		
   		/***** OBSERVER PATTERN *****/
   		
   		// Notification Mail for Feeder stated
   		
   		
			
		
   		if(context.getDataFeeder().getClass().equals(FeederToStart.class)){
   			
   			EmailNotifier emailNotifier = new EmailNotifierImpl(new org.springframework.mail.javamail.JavaMailSenderImpl());
   			
   			EmailDTO emailDTO = new EmailDTO();
   			
   		//	emailNotifier.sendMail(emailDTO,"Feeder to start");
   		}
   		
   		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
   		
   		
   		context.feedStatus();
   		context.feedStateCheck();
   		
   	// Notification Mail for Feeder processing
   		if(context.getDataFeeder().getClass().equals(FeedReader.class)){
   			EmailNotifier emailNotifier = new EmailNotifierImpl(new org.springframework.mail.javamail.JavaMailSenderImpl());
   			
   			EmailDTO emailDTO = new EmailDTO();
   			
   		//	emailNotifier.sendMail(emailDTO,"Feeder is reading");
   		}
   		
   		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
   		
   		
   		context.feedStatus();
   		context.feedStateCheck();

   	// Notification Mail for Feeder done with processing
   		if(context.getDataFeeder().getClass().equals(FeedProcessor.class)){
EmailNotifier emailNotifier = new EmailNotifierImpl(new org.springframework.mail.javamail.JavaMailSenderImpl());
   			
   			EmailDTO emailDTO = new EmailDTO();
   			
   		//	emailNotifier.sendMail(emailDTO,"Feeder is processing");
   		}
   		
   		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		*/
   		
   		context.feedStatus();
   		context.feedStateCheck();
   		
   		if(context.getDataFeeder().getClass().equals(FeedReady.class)){
   			EmailNotifier emailNotifier = new EmailNotifierImpl(new org.springframework.mail.javamail.JavaMailSenderImpl());
   			   			
   			   			EmailDTO emailDTO = new EmailDTO();
   			   			
   			   		//	emailNotifier.sendMail(emailDTO,"feeds are ready");
   			   		}
   	//	}
   		
   		/*context.feedStatus();
   		context.feedStateCheck();
   		
   		context.feedStatus();
   		context.feedStateCheck();*/
   		
   		return "caseAddition";
   	} 
    
    
    
}