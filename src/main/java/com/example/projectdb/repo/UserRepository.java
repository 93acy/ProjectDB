package com.example.projectdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectdb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
