package com.rev.feed;

import java.net.ConnectException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.rev.entity.Quote;
import com.rev.queue.StockDataConsumer;
import com.rev.utility.StockFeedUtility;
import com.rev.utility.WeatherFeedUtility;

public class FeederToStart implements DataFeeder{
	
	private FeedContext feedContext;
	
	private BlockingQueue<Quote> queue = new ArrayBlockingQueue<>(10);

	public FeederToStart(FeedContext feedContext) {
		this.feedContext = feedContext;
	}

	ExecutorService executorService = Executors.newFixedThreadPool(3);

	public void processFeed() {
		System.out.println(" Feeder yet to start");
		
		/*
		 * 
		 * Stock prices: consumer
		 */
		
		StockDataConsumer stockDataConsumer = new StockDataConsumer(queue);
		
		new Thread(stockDataConsumer).start();
		
		System.out.println("Started consumer");
		
		/*
		 * Quotes: Stock prices producer
		 */
		StockFeedUtility stockFeedUtility = new StockFeedUtility(queue);
		
	
		
		
		for(int i=0;i<2;i++){
			Thread t = new Thread(stockFeedUtility);
			t.setName("Thread_ " + i);
			executorService.execute(t);
			//t.start();
		}
		System.out.println("Started All Producers...................");
		executorService.shutdown();
		try {
			if(executorService.awaitTermination(10000, TimeUnit.MILLISECONDS))
				System.out.println(" Finished all threads");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*************************** Stock feeder ends here *******************/
	
		
		/*
		 * 
		 * Feeder for Weather
		 */
		
		/*
		 * Quotes: Stock prices producer
		 */
		WeatherFeedUtility weatherFeedUtility = new WeatherFeedUtility(queue);
		
	
		
		
		for(int i=0;i<3;i++){
			Thread t = new Thread(weatherFeedUtility);
			t.setName("Thread_ " + i);
			executorService.execute(t);
			//t.start();
		}
		System.out.println("Started All Producers");
		executorService.shutdown();
		try {
			if(executorService.awaitTermination(10000, TimeUnit.MILLISECONDS))
				System.out.println(" Finished all threads");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}



	public void changeState() {
		System.out.println(" Feeder to start fetching the feeds ");
		
	}

	

}
