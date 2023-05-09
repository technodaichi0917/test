package com.example.kakeibo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
    public String getHome(Model model) {
        return "home";
    }
	
	@GetMapping("/loginForm")
    public String getLogin() {
        return "loginForm";
    }
	
	@GetMapping("/index")
	public String getIndex(Model model) {
		LocalDate nowDate = LocalDate.now();
		model.addAttribute(nowDate);
		return "index";
	}
	
	@GetMapping("/index2")
	public String getIndex2(Model model) {
		LocalDate nowDate = LocalDate.now();
		model.addAttribute(nowDate);
		return "index2";
	}

	


}
