package com.rev.feed;

public class FeedReady implements DataFeeder{
	
	private FeedContext feedContext;

	public FeedReady(FeedContext feedContext) {
		super();
		this.feedContext = feedContext;
	}

	

	public void processFeed() {
		System.out.println(" Feeder eady to serve the results ");
		
	}



	public void changeState() {
		System.out.println(" Feeder is serving  the results ");
		
	}

	

}
