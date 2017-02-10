package com.rev.queue;

import java.util.concurrent.BlockingQueue;

import com.rev.entity.Quote;

public class StockDataConsumer implements Runnable{

	
	private BlockingQueue<Quote> queue;

	public StockDataConsumer(BlockingQueue<Quote> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		
		/** 
		 * reads the stock upadtes and send to reciepts the updates
		 */
		Quote quote;
		try {
			while((quote = queue.take()).toString()!=null){
				System.out.println(" Consumer : Thread reading quotes " + quote.toString() +"  is ---> " + Thread.currentThread().getName());
			}
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
	
	
	

}
