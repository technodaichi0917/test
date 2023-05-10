package com.example.kakeibo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//支出クラス
@Entity
@Data
public class Spending {

	//Spendingクラスの主キー
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	//収支金額
	@NotNull(message="適切な金額を入力してください。")
	@Column(length=18)
	private Integer spendingAmount;
	
	//収支の日付
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datetime;
	
	//メモ内容
	@NotBlank(message="適切な内容を入力してください。")
	@Column(length=18)
	private String memo;
	
	//外部キーuser
	@ManyToOne
	private User user;
}
