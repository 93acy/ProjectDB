package com.example.projectdb.service;

import com.example.projectdb.model.User;

public interface UserService {
	
	User findByUsernameAndPassword(String name, String password);
	
	User findByUsername(String username);

}
