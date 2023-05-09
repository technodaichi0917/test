package com.example.kakeibo.controller;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kakeibo.model.Income;




@Controller
public class IncomeController {
	
	//新規収入登録ページに遷移
	@GetMapping("/newIncome")
    public String getNewIncome() {
		
        return "newIncome";
    }
	
//	@PostMapping("/newIncome")
//	public String createIncome() {
//		
//		return "index2";
//	}
	
	//フォームから入力された収入変更情報をincomeServiceへ送る。
	@GetMapping("/editIncome")
    public String editIncome() {
		
		return "editIncome" ;
    }
	
//	@PostMapping("/editIncome")
//	public String editIncome() {
//	
//		return "currentMonth";
//	}
//	
	
	
	

}
