package com.rev.feed;

import java.util.List;

import com.rev.entity.Stock;

public class FeedReady implements DataFeeder{
	
	private FeedContext feedContext;
	
	 private List<Stock> stockQuotes;

	public FeedReady(FeedContext feedContext) {
		super();
		this.feedContext = feedContext;
	}

	

	public List<Stock> processFeed() {
		System.out.println(" Feeder eady to serve the results ");
		return stockQuotes;
	}



	public void changeState() {
		System.out.println(" Feeder is serving  the results ");
		
	}

	

}
