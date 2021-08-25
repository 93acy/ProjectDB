package com.example.projectdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.User;
import com.example.projectdb.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserRepository urepo;

	@Override
	public List<User> findAll() {
		return urepo.findAll();
	}

	@Override
	public void save(User newUser) {
		urepo.saveAndFlush(newUser);
		
	}

}
