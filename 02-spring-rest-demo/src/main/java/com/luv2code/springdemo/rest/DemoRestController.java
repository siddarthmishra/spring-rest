package com.luv2code.springdemo.rest;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	// add code for the "/hello" mapping
	@GetMapping("/hello")
	public String sayHello() {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MMMM-yyy hh:mm:ss a VV");
		String zonedDateTimeFormattedText = zonedDateTime.format(formatter);
		return "Hello World!!! Today is " + zonedDateTimeFormattedText;
	}

}
