package com.example.kakeibo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kakeibo.model.Income;
import com.example.kakeibo.model.Spending;
import com.example.kakeibo.repository.IncomeRepository;
import com.example.kakeibo.repository.SpendingRepository;

@Service
public class CalculateService {
	

	private int currentIncomeTotal;
	private int currentSpendingTotal;
	private int currentMonthTotal;
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@Autowired
	SpendingRepository spendingRepository;
	
	@Autowired
	IncomeService incomeService;
	
	@Autowired
	SpendingService spendingService;
	
	public int getCurrentIncomeTotal() {
		LocalDate now = LocalDate.now();
		LocalDate start = now.withDayOfMonth(1);
		LocalDate end = now.withDayOfMonth(now.lengthOfMonth());
		List<Income> list = incomeRepository.findAllByDatetimeBetween(start,end);
		currentIncomeTotal = 0;
		for (Income income:list) {
			currentIncomeTotal+= income.getIncomeAmount();
		}
		return currentIncomeTotal;
	}
	
	public int getCurrentSpendingTotal() {
		LocalDate now = LocalDate.now();
		LocalDate start = now.withDayOfMonth(1);
		LocalDate end = now.withDayOfMonth(now.lengthOfMonth());
		List<Spending> list = spendingRepository.findAllByDatetimeBetween(start,end);
		currentSpendingTotal = 0;
		for (Spending spending:list) {
			currentSpendingTotal+= spending.getSpendingAmount();
		}
		return currentSpendingTotal;
		
	}
	
	public int getCurrentMonthTotal() {
		currentMonthTotal = 0;
		currentMonthTotal = currentIncomeTotal - currentSpendingTotal;
		return currentMonthTotal; 
		
	}
	
	
	
}