package com.rev.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.rev.entity.Stock;
import com.rev.entity.Stock;

public class StockFeedUtility implements Callable<List<Stock>>{

	private List<String> urlList = new ArrayList<>();
	
	private Map<String,Stock> conMap = new ConcurrentHashMap<>();
	
	private List<Stock> stockQuotes = new LinkedList<Stock>();
	
	private BlockingQueue<Stock> queue;
	 int i=0;
	public StockFeedUtility(BlockingQueue<Stock> queue) {
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
		public List<Stock> call() {
			//synchronized (FeedUtility.class) {
				
			while(true){
			if(i==2){
				System.out.println(" Stream fetching data had ended... ");
				return null;
			}else{
			try{
				RestTemplate restTemplate = new RestTemplate();
				 SimpleClientHttpRequestFactory requestFactory = (SimpleClientHttpRequestFactory) restTemplate
			                .getRequestFactory();
			    requestFactory.setReadTimeout(100000);
			    requestFactory.setConnectTimeout(100000);
			    
			    String str = urlList.get(i++);
			  // System.out.println(" Thread executing is  " + Thread.currentThread().getName()+" URL is " + str);
			    Stock stock = restTemplate.getForObject(str, Stock.class);
			    //Stock[] q = restTemplate.getForEntity(urlList.get(i++), Stock[].class);
			 //   Arrays.asList(Stock);
			    System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
			    System.out.println(" Producer: Stock Utility : Thread executing is  " + Thread.currentThread().getName()+" Stock is  " + stock.toString());
			    // adding to concurrent map
			    stockQuotes.add(stock);
			    
			   // StockMap.getInstance().put(Stock.getTitle()==null?"dummy":Stock.getTitle(), Stock);
				//System.out.println(" --> "+ Stock);
				queue.put(stock);// put into the queue the stock latest Stocks 
				}catch (Exception e) {
					e.printStackTrace();
				}
			return stockQuotes;
			}
			}
		//	}
			
		}
		
		
		

	}

