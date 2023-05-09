package com.example.kakeibo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TotalController {
	
	
	//今月の収入・支出の情報をそれぞれ一覧表示(金額、日付、メモ)
	//今月の収入合計金額の表示
	//今月の支出合計金額の表示
	//今月の収支合計金額の表示
	
	//今月の収支一覧画面へ遷移
	@GetMapping("/currentMonthTotal")
	public String getCurrentMonthTotal() {
		return "currentMonthTotal";
	}
	
	//別月の収入・支出の情報をそれぞれ一覧表示(金額、日付、メモ)
	//別月の収入合計金額の表示
	//別月の支出合計金額の表示
	//別月の収支合計金額の表示
	
	//別月の収支一覧画面へ遷移
	@GetMapping("/serchMonthTotal")
	public String getOtherMonthTotal() {
		return "serchMonthTotal";
	}

}
