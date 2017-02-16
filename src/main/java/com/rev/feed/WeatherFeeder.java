package com.rev.feed;

import java.util.List;

import com.rev.dto.EmailDTO;
import com.rev.entity.Stock;

public class WeatherFeeder extends FeederTemplate{

	private List<Stock> stockQuotes;
	
	@Override
	protected  void feedStateChecker(FeedContext context) {
		
		 context.getDataFeeder().processFeed();
		
	}

	@Override
	protected List<Stock> processFeed(FeedContext context) {
		
		
   		

   		if(context.getDataFeeder().getClass().equals(FeedProcessor.class)){
   			
   			EmailDTO emailDTO = new EmailDTO();
   			
   		}
		
		context.feedStateChecker();
		
		return context.processFeed();
		
	}

}
