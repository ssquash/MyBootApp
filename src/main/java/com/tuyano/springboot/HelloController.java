package com.tuyano.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/{num}")
	public String index(@PathVariable int num) {
		int result = 0;
		for(int i = 0; i <= num; i++) 
			result += i;
		return "total: " + result;
	}
}
