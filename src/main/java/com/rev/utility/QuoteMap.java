package com.rev.utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rev.entity.Quote;

public class QuoteMap{

    private Map<String, Quote> map = new ConcurrentHashMap();
	// private Map<String, Quote> map = Collections.synchronizedMap(new HashMap());

    private static QuoteMap instance = null;

    public Map<String, Quote> getMap() {
		return map;
	}

	/*public void setMap(Map<String, Quote> map) {
		this.map = map;
	}*/

	private QuoteMap() {}

    public static QuoteMap getInstance() {
        if (instance == null)
            instance = new QuoteMap();
        return instance;
    }

    public void put(String string, Quote quote) {
        map.put(string,quote);       
    }
}