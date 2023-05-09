package com.example.kakeibo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "適切な金額を入力してください。")
	@Column(length = 18)
	private Integer incomeAmount;
	
	
	private LocalDate datetime;
	
	@NotBlank(message = "適切な内容を入力してください。")
	@Column(length = 18)
	private String memo;
	
	@ManyToOne
    private User user;
	
}