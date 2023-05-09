package com.example.kakeibo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakeibo.model.Spending;

public interface SpendingRepository extends JpaRepository<Spending, Integer>{
	List<Spending> findAllByDatetimeBetween(LocalDate start, LocalDate end);
}
