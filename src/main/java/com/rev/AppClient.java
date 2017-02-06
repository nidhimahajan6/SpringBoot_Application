
package com.rev;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan() 
@EnableAutoConfiguration
/*@EnableWebMvc*/
//@EnableJpaRepositories(basePackages="com.rev.repository", entityManagerFactoryRef="com.rev.repository.StudentRepository")
public class AppClient{

    public static void main(String[] args) {

        SpringApplication.run(AppClient.class, args);

    }
    
    
   

}