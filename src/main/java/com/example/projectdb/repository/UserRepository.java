package com.example.projectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectdb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}