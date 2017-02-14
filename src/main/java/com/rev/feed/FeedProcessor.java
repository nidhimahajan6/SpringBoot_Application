package com.rev.feed;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.rev.entity.Quote;
import com.rev.utility.FeedProcessorUtility;

public class FeedProcessor implements DataFeeder{
	
	private FeedContext feedContext;

	public FeedProcessor(FeedContext feedContext) {
		super();
		this.feedContext = feedContext;
	}

	
	private Map<String,Quote> conMap;// = new ConcurrentHashMap<>();
	public void processFeed() {
		System.out.println(" Feeder processing the feeds.............. ");
		
		/*
		 * 
		 * her to initialte the ConcurrentHashMap
		 */
		
	//	BlockingQueue<Quote> queue;
		
		
		//FeedProcessorUtility utility = new FeedProcessorUtility(conMap);
		FeedProcessorUtility utility = new FeedProcessorUtility();
		ExecutorService eService = Executors.newCachedThreadPool();
		long start = System.nanoTime();
		System.out.println(" start " + start);
		for(int i=0;i<3;i++){
			Thread t = new Thread(utility);
			t.setName("Thread_ " + i);
			eService.execute(t);
		   // t.start();
		}
		eService.shutdown();
		try {
			if(eService.awaitTermination(10000, TimeUnit.MILLISECONDS))
				System.out.println(" Finished processing map ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(" time elaspsed  " + (System.nanoTime() - start));
	}



	public void changeState() {
		System.out.println(" Feeder is ready to serve ");
		
	}

	

}
