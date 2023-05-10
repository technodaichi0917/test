package com.example.kakeibo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Income> incomelist = incomeService.getCurrentIncomeList();
		List<Spending> spendinglist = spendingService.getCurrentSpendingList();
		int incomeTotal = calculateService.getCurrentIncomeTotal();
		int spendingTotal = calculateService.getCurrentSpendingTotal();
		int monthTotal = calculateService.getCurrentMonthTotal();
		model.addAttribute("incomelist", incomelist);
		model.addAttribute("spendinglist", spendinglist);
		model.addAttribute("incomeTotal", incomeTotal);
		model.addAttribute("spendingTotal", spendingTotal);
		model.addAttribute("monthTotal", monthTotal);
		return "currentMonthTotal";
	}
	
	@GetMapping("/serchMonthTotal")
	public String getOtherMonthTotal(Model model, @RequestParam int year, @RequestParam int month) {
//		
//		List<Income> incomelist = incomeService.getIncomeList(year,month);
//	    List<Spending> spendinglist = spendingService.getSpendingList(year,month);
//	    
//	    int incomeTotal = calculateService.getIncomeTotal(year,month);
//	    int spendingTotal = calculateService.getSpendingTotal(year,month);
//	    int monthTotal = calculateService.getMonthTotal();
//	    model.addAttribute("incomelist", incomelist);
//	    model.addAttribute("spendinglist", spendinglist);
//	    model.addAttribute("incomeTotal", incomeTotal);
//	    model.addAttribute("spendingTotal", spendingTotal);
//	    model.addAttribute("monthTotal", monthTotal);
		
		return "serchMonthTotal";
	}
}
