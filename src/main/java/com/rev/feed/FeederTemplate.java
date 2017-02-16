package com.rev.feed;

import java.util.List;

import com.rev.entity.Stock;

public abstract class FeederTemplate {

	public final void feedProcessor(){
		
		FeedContext context = new FeedContext();
		
		feedStateChecker(context);
		
		processFeed(context);
		
	}
	
	
	
	
	protected abstract void feedStateChecker(FeedContext context);
	
	protected abstract List<Stock> processFeed(FeedContext context);
	
	
}


