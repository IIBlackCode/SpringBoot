package com.blackcode.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
	@GetMapping("/")
	public String home() {
		System.out.println("HOME CONTROLLER");
//		return "/index";
		return "thymeleaf/index.html";
	}
}

// Github token
// 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