package com.everis.microservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.microservices.models.Greetings;

@RestController
public class MainController {
	
	public static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greetings greeting(@RequestParam(value="name",defaultValue="World") String name) {
		return new Greetings(counter.incrementAndGet(),String.format(template, name));
	}
	
}
