package com.rev.feed;

import java.util.List;

import com.rev.entity.Stock;

public interface DataFeeder {
	
	
//	void fetchFeed();
	
	List<Stock> processFeed();
	
	void changeState();

}
