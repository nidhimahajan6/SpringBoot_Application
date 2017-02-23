package com.rev.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
	

	    @Override
	public String toString() {
		return "Stock [price=" + price + ", name=" + name + "]";
	}

		private  long price;
	    private  String name;
	    
	    

	    public Stock() {
		}

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
