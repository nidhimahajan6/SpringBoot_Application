package com.rev.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.rev.entity.Quote;

public class StockFeedUtility implements Runnable{

	private List<String> urlList = new ArrayList<>();
	
	private Map<String,Quote> conMap = new ConcurrentHashMap<>();
	
	private BlockingQueue<Quote> queue;
	 int i=0;
	public StockFeedUtility(BlockingQueue<Quote> queue) {
		super();
		this.queue = queue;
	}

	{
	
		urlList.add("http://localhost:8080/stocks/SampleData/");
	urlList.add("http://services.groupkt.com/country/get/iso2code/IN");
	/*urlList.add("http://geo.groupkt.com/ip/172.217.3.14/json/");
	urlList.add("http://date.jsontest.com/?service=ip");*/
	//urlList.add("http://echo.jsontest.com/title/ipsum/content/");
	//urlList.add("api.openweathermap.org/data/2.5/weather?q=London");
	/*for(int i=0;i<28;i++){
		urlList.add("http://echo.jsontest.com/key/value/one/two");
	}*/
	/*urlList.add("http://echo.jsontest.com/key/value/one/two");
	urlList.add("https://jsonplaceholder.typicode.com/photos");*/
	}
	
		@Override
		public void run() {
			//synchronized (FeedUtility.class) {
				
			while(true){
			if(i==2){
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
			    //Quote[] q = restTemplate.getForEntity(urlList.get(i++), Quote[].class);
			    Arrays.asList(quote);
			    System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
			    System.out.println(" Producer: Stock Utility : Thread executing is  " + Thread.currentThread().getName()+" Quote is  " + quote.toString());
			    // adding to concurrent map
			    
			    
			    QuoteMap.getInstance().put(quote.getTitle()==null?"dummy":quote.getTitle(), quote);
				//System.out.println(" --> "+ quote);
				queue.put(quote);// put into the queue the stock latest quotes 
				}catch (Exception e) {
					e.printStackTrace();
				}
			return;
			}
			}
		//	}
			
		}
		
		
		

	}

