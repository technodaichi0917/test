package com.example.kakeibo.controller;



import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kakeibo.model.Income;
import com.example.kakeibo.repository.IncomeRepository;
import com.example.kakeibo.service.IncomeService;

@Controller
public class IncomeController {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private IncomeService incomeService;
	
	//新規収入登録ページに遷移
	@GetMapping("/newIncome")
    public String getNewIncome(Model model, Income income) {
		LocalDate nowDate = LocalDate.now();
		model.addAttribute("nowDate", nowDate);
        return "newIncome";
    }
	
	@PostMapping("/newIncome")
	public String createIncome(Income income) {
		
		incomeRepository.save(income);
		return "index2";
	}
	
	//フォームから入力された収入変更情報をincomeServiceへ送る。
	@GetMapping("/editIncome/{incomeId}")
    public String editIncome(@PathVariable("incomeId") Income income, Model model) {
		
		model.addAttribute("income", income);
		return "editIncome";
    }
	
	@PostMapping("/editIncome/{incomeId}")
	public String editIncome(@PathVariable("incomeId") Income income) {
		
		incomeService.updateIncome(income,income.getIncomeAmount(),income.getDatetime(),income.getMemo());
		return "currentMonth";
	}
	
	
	
	

}
