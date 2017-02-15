package com.rev.feed;



public abstract class FeederTemplate {

	public final void feedProcessor(){
		
		FeedContext context = new FeedContext();
		
		feedStateChecker(context);
		
		processFeed(context);
		
	}
	
	
	
	
	protected abstract void feedStateChecker(FeedContext context);
	
	protected abstract void processFeed(FeedContext context);
	
	
}


