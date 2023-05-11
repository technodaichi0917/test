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
	
}
