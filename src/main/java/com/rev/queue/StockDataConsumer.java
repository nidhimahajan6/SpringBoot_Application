package com.rev.queue;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import com.rev.entity.Quote;
import com.rev.entity.Stock;
import com.rev.repo.StockComparator;
import com.rev.repo.StockTree;

public class StockDataConsumer implements Callable<List<Stock>>{

	
	private BlockingQueue<Stock> queue;

	private List<Stock> stockQuotes;
	
	private StockTree stockRepo = new StockTree(new StockComparator());//  AVL TREE FOR THE INSERTION TO BE log(n)
	
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
		Stock stock;
		try {
			while((stock = queue.take()).toString()!=null){
				
				stockQuotes.add(stock);// to render to the client first as on dahboard
				stockRepo.insert(stockRepo.getRoot(), stock);// to be used for the fast retreival and Cache
				System.out.println(" Consumer : Thread reading quotes " + stock.toString() +"  is ---> " + Thread.currentThread().getName());
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
