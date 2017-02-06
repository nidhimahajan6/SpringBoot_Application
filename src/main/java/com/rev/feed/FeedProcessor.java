package com.rev.feed;

public class FeedProcessor implements DataFeeder{
	
	private FeedContext feedContext;

	public FeedProcessor(FeedContext feedContext) {
		super();
		this.feedContext = feedContext;
	}

	

	public void processFeed() {
		System.out.println(" Feeder processing the feeds ");
		
	}



	public void changeState() {
		System.out.println(" Feeder is ready to serve ");
		
	}

	

}
