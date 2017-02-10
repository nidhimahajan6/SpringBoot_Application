package com.rev.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.rev.entity.Quote;

public class FeedUtility implements Runnable{

	List<String> urlList = new ArrayList<>();
	private BlockingQueue<Quote> queue;
	 int i=0;
	public FeedUtility(BlockingQueue<Quote> queue) {
		super();
		this.queue = queue;
	}

	{
	
	urlList.add("http://echo.jsontest.com/title/ipsum/content/blah");
	urlList.add("http://echo.jsontest.com/title/ipsum/");
	urlList.add("http://date.jsontest.com/?service=ip");
	urlList.add("http://echo.jsontest.com/title/ipsum/content/");
	urlList.add("api.openweathermap.org/data/2.5/weather?q=London");
	for(int i=0;i<28;i++){
		urlList.add("http://echo.jsontest.com/key/value/one/two");
	}
	/*urlList.add("http://echo.jsontest.com/key/value/one/two");
	urlList.add("https://jsonplaceholder.typicode.com/photos");*/
	}
	
		@Override
		public void run() {
			//synchronized (FeedUtility.class) {
				
			
			if(i==31){
				System.out.println(" Stream fetching data had ended... ");
				return;
			}else{
			try{
				RestTemplate restTemplate = new RestTemplate();
				 SimpleClientHttpRequestFactory requestFactory = (SimpleClientHttpRequestFactory) restTemplate
			                .getRequestFactory();
			    requestFactory.setReadTimeout(100000);
			    requestFactory.setConnectTimeout(100000);
			    
			    String str = urlList.get(i++);
			  // System.out.println(" Thread executing is  " + Thread.currentThread().getName()+" URL is " + str);
			    Quote quote = restTemplate.getForObject(str, Quote.class);
			    System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
			    System.out.println(" Producer : Thread executing is  " + Thread.currentThread().getName()+" Quote is  " + quote.toString());
				//System.out.println(" --> "+ quote);
				queue.put(quote);// put into the queue the stock latest quotes 
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		//	}
			
		}
		
		
		

	}

