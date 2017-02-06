package com.rev.service;

import com.rev.dto.EmailDTO;
import com.rev.utility.MailStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import javax.mail.internet.MimeMessage;

public class EmailNotifierImpl implements EmailNotifier{
	
	private JavaMailSenderImpl mailSender;// = new org.springframework.mail.javamail.JavaMailSenderImpl();
	
	Properties props = new Properties();
   
	List<String> listOfReceipents = new ArrayList<>();
	
	

	public  EmailNotifierImpl(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		/*props.put("username", "akkhil2012@gmail.com");
		props.put("password", "Kapil_00@c");*/
		this.mailSender.setJavaMailProperties(props);
		this.mailSender.setProtocol("smtp");
		this.mailSender.setHost("smtp.gmail.com");
		this.mailSender.setPort(587);
		this.mailSender.setUsername("akkhil2012@gmail.com");
		this.mailSender.setPassword("Kapil_00@c");   
		
		listOfReceipents.add("nidhimahajan6@gmail.com");
		listOfReceipents.add("akkhil2012@gmail.com");
		
		
	}


	public MailStatus sendMail(EmailDTO emailDTO,final String text) {
		//final MailStatus mailStatu = new MailSta
	//	synchronized (EmailNotifierImpl.class) {
			
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage message) throws Exception {
				String[] recipientArray = listOfReceipents.toArray(new String[listOfReceipents.size()]);
				MimeMessageHelper msg = new MimeMessageHelper(message, true, "UTF-8");
				msg.setFrom("akkhilTest@mail.com");
				msg.setTo("akkhil2016@yahoo.com");
				msg.setBcc(recipientArray);
				//msg.setSubject("Feeder Started.........");
				msg.setSubject(text);
				msg.setText(text, true);
			     //message.addInline("myLogo", new ClassPathResource("img/mylogo.gif"));
				
			}
			
		};
		
		
		try{
		this.mailSender.send(preparator);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Mail Sent ..............");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MailStatus.MailSent;
	}
//	}
	

}
