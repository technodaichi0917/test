package com.example.kakeibo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakeibo.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer>{
	List<Income> findAllByDatetimeBetween(LocalDate start, LocalDate end);
}
