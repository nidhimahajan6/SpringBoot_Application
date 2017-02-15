
package com.rev;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * 
 * Stock servng endpoint: http://localhost:8083/stock/SampleData.json
 *  tomact: C:\Software_Personal\apache-tomcat-7\apache-tomcat-7.0.73\webapps
 */

@SpringBootApplication
@ComponentScan() 
@EnableAutoConfiguration
public class AppClient{
    public static void main(String[] args) {
        SpringApplication.run(AppClient.class, args);
      
    }
}