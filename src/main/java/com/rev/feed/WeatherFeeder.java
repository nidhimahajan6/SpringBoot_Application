package com.rev.feed;

import com.rev.dto.EmailDTO;

public class WeatherFeeder extends FeederTemplate{

	@Override
	protected void feedStateChecker(FeedContext context) {
		
		context.getDataFeeder().processFeed();
		
	}

	@Override
	protected void processFeed(FeedContext context) {
		
		context.processFeed();
   		

   		if(context.getDataFeeder().getClass().equals(FeedProcessor.class)){
   			
   			EmailDTO emailDTO = new EmailDTO();
   			
   		}
		
		context.feedStateChecker();
		
	}

}
