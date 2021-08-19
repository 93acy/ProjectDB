package com.example.projectdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.User;
import com.example.projectdb.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository urepo;
	
	@Override
	public User findByUsernameAndPassword(String name, String password) {
		return urepo.findByUsernameAndPassword(name, password);
	}

	@Override
	public User findByUsername(String username) {
		return urepo.findByUsername(username);
	}

}
