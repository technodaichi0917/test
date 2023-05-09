package com.example.kakeibo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message="適切な名前を入力してください。")
	@Column(length=18)
	private String username;
	
	@NotBlank(message="適切なパスワードを入力してください。")
	@Column(length=18)
	private String password;
	
	@OneToMany(mappedBy = "user")
    private List<Income> income;
	
	@OneToMany(mappedBy = "user")
    private List<Spending> spending;

}