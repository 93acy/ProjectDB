package com.example.projectdb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.User;
import com.example.projectdb.model.UserOrder;
import com.example.projectdb.model.UserOrderDetail;
import com.example.projectdb.repo.UserOrderDetailRepository;
import com.example.projectdb.repo.UserOrderRepository;
import com.example.projectdb.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserRepository urepo;
	
	
	@Autowired 
	private UserOrderRepository uorepo;
	
	@Autowired 
	private UserOrderDetailRepository uodRepo;

	@Override
	public List<User> findAll() {
		return urepo.findAll();
	}

	@Override
	public void save(User newUser) {
		urepo.saveAndFlush(newUser);
	}

	@Override
	public void saveUserOrder(UserOrder userOrder) {
		uorepo.saveAndFlush(userOrder);
		
	}

	@Override
	public void updateCourierListingId(Long userOrderId, Long courierListingId) {
		
		uorepo.updateCourierListingId( userOrderId,  courierListingId);
		
	}

	@Override
	public void saveUserOrderDetail(UserOrderDetail userOrderDetail) {
		uodRepo.save(userOrderDetail);
		
	}

	@Override
	public void updateOrderIdAndCFID(Long userOrderId, Long courierFoodItemId, Long userOrderDetailId) {
		
		uodRepo.updateOrderIdAndCFID(userOrderId, courierFoodItemId, userOrderDetailId);
	}


	@Override
	public User findByUsernameAndPassword(String name, String password) {
		return urepo.findByUsernameAndPassword(name, password);
	}

	@Override
	public User findByUsername(String username) {
		return urepo.findByUsername(username);
	}
	
	@Override
	public Integer getOrderQuantityById(Long userOrderDetailId) {
		
		return uodRepo.getOrderQuantityById(userOrderDetailId);
	}

}
