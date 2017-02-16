package com.rev.feed;

import java.util.List;

import com.rev.entity.Stock;

public class FeedContext {
	
	
	private DataFeeder dataFeeder;
	
	
	public DataFeeder getDataFeeder() {
		return dataFeeder;
	}

	public void setDataFeeder(DataFeeder dataFeeder) {
		this.dataFeeder = dataFeeder;
	}

	public FeedContext(){
		this.dataFeeder = new FeederToStart(this);
	}

	/*public FeedContext(DataFeeder dataFeeder) {
		this.dataFeeder = new FeederToStart(this);
	}*/
	
	
	public void feedStateChecker(){
		
		if(dataFeeder.getClass().equals(FeederToStart.class)){
			this.dataFeeder = new FeedReader(this);
			this.dataFeeder.changeState();
			
		}else if(dataFeeder.getClass().equals(FeedReader.class)) {
			this.dataFeeder = new FeedProcessor(this);
			this.dataFeeder.changeState();
		}else if(dataFeeder.getClass().equals(FeedProcessor.class)) {
			this.dataFeeder = new FeedReady(this);
			this.dataFeeder.changeState();
		}
	}
	
	
	public List<Stock> processFeed(){
		return this.dataFeeder.processFeed();
	}
	
	

}
