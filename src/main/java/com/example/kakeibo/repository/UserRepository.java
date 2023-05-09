package com.example.kakeibo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakeibo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
}
