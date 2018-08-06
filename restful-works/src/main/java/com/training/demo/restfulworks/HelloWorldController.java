package com.training.demo.restfulworks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	// @RequestMapping(method = RequestMethod.GET, path = "hello-world")
	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorld helloWord() {
		return new HelloWorld("Hello world");
	}

	// we have to get it from end user
	// http://localhost:8080/hello-world/Birendra
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld("Hello Mr/Mrs : "+name);
	}
}
