package com.example.kakeibo.service;


import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kakeibo.model.Income;
import com.example.kakeibo.repository.IncomeRepository;

@Service
public class IncomeService {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	public List<Income> getCurrentIncomeList() {
		LocalDate now = LocalDate.now();
		LocalDate start = now.withDayOfMonth(1);
		LocalDate end = now.withDayOfMonth(now.lengthOfMonth());
		List<Income> incomelist = incomeRepository.findAllByDatetimeBetween(start,end);
		return incomelist;
	}
	
	public List<Income> getOtherIncomeList(int year, int month){
		LocalDate start = LocalDate.of(year, month,1);
		LocalDate end = start.plusMonths(1).minusDays(1);
		return incomeRepository.findAllByDatetimeBetween(start,end);
	}
	
	public void updateIncome(Income income) {
		incomeRepository.save(income);
	}
}


