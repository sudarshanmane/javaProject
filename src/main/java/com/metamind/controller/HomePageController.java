package com.metamind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	@GetMapping("/homePage")
	public String homePageController(){
		
		return "homepage/homePage";
	}
	
}
