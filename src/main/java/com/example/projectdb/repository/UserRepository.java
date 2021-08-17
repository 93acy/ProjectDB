package com.example.projectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectdb.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsernameAndPassword(String name, String password);
	
	User findByUsername(String username);
}

