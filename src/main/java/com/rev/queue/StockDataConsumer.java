package com.rev.queue;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import com.rev.entity.Quote;
import com.rev.entity.Stock;

public class StockDataConsumer implements Callable<List<Stock>>{

	
	private BlockingQueue<Stock> queue;

	private List<Stock> stockQuotes;
	
	public StockDataConsumer(BlockingQueue<Stock> queue) {
		super();
		this.queue = queue;
	}
	
	/* concurreny using concurrntHashMap
	 */
	
	

	@Override
	public List<Stock> call() {
		
		/** 
		 * reads the stock upadtes and send to reciepts the updates
		 */
		Stock quote;
		try {
			while((quote = queue.take()).toString()!=null){
				
				stockQuotes.add(quote);
				System.out.println(" Consumer : Thread reading quotes " + quote.toString() +"  is ---> " + Thread.currentThread().getName());
			}
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stockQuotes;
		
	}
	
	

	
	
	
	

}
