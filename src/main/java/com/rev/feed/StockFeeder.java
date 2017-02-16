package com.rev.feed;

import java.util.List;

import com.rev.dto.EmailDTO;
import com.rev.entity.Stock;

public class StockFeeder extends FeederTemplate{

	@Override
	protected List<Stock> processFeed(FeedContext context) {
		
		return context.getDataFeeder().processFeed();
	}

	@Override
	protected void feedStateChecker(FeedContext context) {
		
		context.processFeed();
   		

   		if(context.getDataFeeder().getClass().equals(FeedProcessor.class)){
   			
   			EmailDTO emailDTO = new EmailDTO();
   			
   		}
		
		context.feedStateChecker();
	}

}
