package com.example.kakeibo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpendingController {
	
	//新規支出登録ページに遷移
	@GetMapping("/newSpending")
	public String getNewSpending() {
	return "newSpending";
	}
	
	//フォームから入力された新規支出登録情報を保存
//	@PostMapping()
//	public String createSpending() {
//		return "";
//	}
	
	//支出情報更新ページに遷移
	@GetMapping("/editSpending")
	public String editSpending() {
		return "editSpending";
	}
	
	//フォームから入力された支出更新情報をspendingServiceへ送る
//	@PostMapping()
//	public String editSpending() {
//		return "";
//	}
}
