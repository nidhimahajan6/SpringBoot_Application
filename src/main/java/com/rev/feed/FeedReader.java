package com.rev.feed;

import java.util.List;

import com.rev.entity.Stock;

public class FeedReader implements DataFeeder{
	
	private List<Stock> stockQuotes;
	private FeedContext feedContext;

	public FeedReader(FeedContext feedContext) {
		super();
		this.feedContext = feedContext;
	}

	

	public List<Stock> processFeed() {
		System.out.println(" Waiting for feed feching to complete  ");
		return stockQuotes;
	}



	public void changeState() {
		System.out.println(" Start processing the feed  ");
		
	}



}
