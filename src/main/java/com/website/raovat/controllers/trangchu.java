package com.website.raovat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class trangchu {
	@GetMapping
	public String GetTrangChu() {
		return "home";
	}
	
	@PostMapping
	public String PostTrangChu() {
		return "home";
	}
}
