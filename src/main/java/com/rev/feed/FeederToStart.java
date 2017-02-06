package com.rev.feed;



public class FeederToStart implements DataFeeder{
	
	private FeedContext feedContext;

	public FeederToStart(FeedContext feedContext) {
		this.feedContext = feedContext;
	}

	

	public void processFeed() {
		System.out.println(" Feeder yet to start");
		
	}



	public void changeState() {
		System.out.println(" Feeder to start fetching the feeds ");
		
	}

	

}
