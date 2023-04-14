package com.example.hojinToyProj.main;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestCon {

		
	@GetMapping(value = {"/"})
	public Map<String,Object> restCon() throws IllegalAccessException{
		//Map<String,Object> res = new HashMap<String,Object>();
		
		throw new IllegalAccessException();
		
	}
}
