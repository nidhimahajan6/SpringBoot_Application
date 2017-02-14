package com.rev.utility;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rev.entity.Quote;

public class FeedProcessorUtility implements Runnable{

	/*private Map<String,Quote> conMap;
	
	public FeedProcessorUtility(Map<String, Quote> conMap) {
		this.conMap = conMap;
	}*/
	private Map<String,Quote> conMap = QuoteMap.getInstance().getMap();
	@Override
	public void run() {
		
		for(Map.Entry<String, Quote> mp : conMap.entrySet()){
			System.out.println(" key -->" + mp.getKey()+"  value is " + mp.getValue()+"  thread is " + Thread.currentThread().getName());
		}
		
	}
	
	
}
