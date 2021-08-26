package com.example.projectdb.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.repo.UserOrderRepository;

@Service
public class UserOrderServiceImpl implements UserOrderService{

	@Autowired 
	private UserOrderRepository uorepo;
	
	@Override
	public ArrayList<ArrayList<String>> findUserOrder() {
		return uorepo.findUserOrder();
	}

}
