package com.rev.feed;

public class FeedReader implements DataFeeder{
	
	
	private FeedContext feedContext;

	public FeedReader(FeedContext feedContext) {
		super();
		this.feedContext = feedContext;
	}

	

	public void processFeed() {
		System.out.println(" Waiting for feed feching to complete  ");
		
	}



	public void changeState() {
		System.out.println(" Start processing the feed  ");
		
	}



}
