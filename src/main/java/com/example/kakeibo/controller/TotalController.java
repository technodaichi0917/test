package com.example.kakeibo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kakeibo.model.Income;
import com.example.kakeibo.model.Spending;
import com.example.kakeibo.service.CalculateService;
import com.example.kakeibo.service.IncomeService;
import com.example.kakeibo.service.SpendingService;

@Controller
public class TotalController {
	
	
	@Autowired
	IncomeService incomeService;
	
	@Autowired
	SpendingService spendingService;
	
	@Autowired
	CalculateService calculateService;
	
	@GetMapping("/currentMonthTotal")
	public String getCurrentMonthTotal(Model model) {
		LocalDate nowDate = LocalDate.now();
		model.addAttribute("nowDate", nowDate);
		//incomelistで全件取得
		List<Income> incomelist = incomeService.getCurrentIncomeList();
		List<Spending> spendinglist = spendingService.getCurrentSpendingList();
		int currentIncomeTotal = calculateService.getCurrentIncomeTotal();
		int currentSpendingTotal = calculateService.getCurrentSpendingTotal();
		int currentMonthTotal = calculateService.getCurrentMonthTotal();
		model.addAttribute("incomelist", incomelist);
		model.addAttribute("spendinglist", spendinglist);
		model.addAttribute("currentIncomeTotal", currentIncomeTotal);
		model.addAttribute("currentSpendingTotal", currentSpendingTotal);
		model.addAttribute("currentMonthTotal", currentMonthTotal);
		return "currentMonthTotal";
	}
	
	@PostMapping("/serchMonthTotal")
	public String postTotal(@RequestParam int year, @RequestParam int month, Model model) {
		 model.addAttribute("year", year);
		 model.addAttribute("month", month);
		 return "serchMonthTotal";
	}
	
	
	@GetMapping("/serchMonthTotal")
	public String getTotal(Model model, @RequestParam int year, @RequestParam int month) {
		
		
		List<Income> incomelist = incomeService.getOtherIncomeList(year,month);
	    List<Spending> spendinglist = spendingService.getOtherSpendingList(year,month);
	    
	    int otherIncomeTotal = calculateService.getOtherIncomeTotal(year,month);
	    int otherSpendingTotal = calculateService.getOtherSpendingTotal(year,month);
	    int otherMonthTotal = calculateService.getOtherMonthTotal();
	    
	    model.addAttribute("year", year);
	    model.addAttribute("month", month);
	    model.addAttribute("incomelist", incomelist);
	    model.addAttribute("spendinglist", spendinglist);
	    model.addAttribute("otherIncomeTotal", otherIncomeTotal);
	    model.addAttribute("otherSpendingTotal", otherSpendingTotal);
	    model.addAttribute("otherMonthTotal", otherMonthTotal);
		
		return "redirect:/serchMonthTotal";
	}
	
}
