package com.rev.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.entity.Stock;

@RestController
public class StockEndPoint {
	
	
		private static final String template = "Stock Prices are , %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @GetMapping("/stocks/SampleData/")
	    public @ResponseBody Stock stockValues(@RequestParam(value="name", required=false, defaultValue="0.0") String name) {
	        return new Stock(counter.incrementAndGet(), String.format(template, name+counter.incrementAndGet()));
	    }

}
