package com.example.projectdb.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<List<String>> findByCourierListingId(Long id){
		return uorepo.findByCourierListingId(id);
	}
	
	public List<List<String>> findUserDetailsByCourierListingId(Long id){
		return uorepo.findUserDetailsByCourierListingId(id);
	}

}
