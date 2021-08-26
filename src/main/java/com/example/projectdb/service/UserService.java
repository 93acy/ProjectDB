package com.example.projectdb.service;


import java.util.List;

import com.example.projectdb.model.User;

public interface UserService {

	public List<User> findAll();
	
	public void save(User newUser);

	User findByUsernameAndPassword(String name, String password);
	
	User findByUsername(String username);


}
