package com.website.raovat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	
	@RequestMapping("/test")
	public void test(@RequestParam String user)
	{
		System.out.println(user);
	}
}
