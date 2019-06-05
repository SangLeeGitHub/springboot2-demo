package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class DemoAppController {

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "Hello World! Test";
	}

	@RequestMapping("/jeonghwan")
	@ResponseBody
	public String jeonghwan() {
		return "Hello World! jeonghwan";
	}
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	@ResponseBody
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
