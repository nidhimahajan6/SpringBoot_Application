package com.rev.entity;

public class Stock {
	

	    private final long price;
	    private final String name;

	    public Stock(long price, String name) {
	        this.price = price;
	        this.name = name;
	    }

	    public long getId() {
	        return price;
	    }

	    public String getContent() {
	        return name;
	    }

	

}
