package com.example.projectdb.service;


import java.util.List;

import com.example.projectdb.model.User;
import com.example.projectdb.model.UserOrder;
import com.example.projectdb.model.UserOrderDetail;

public interface UserService {

	public List<User> findAll();
	
	public void save(User newUser);
	
	public void saveUserOrder(UserOrder userOrder);
	
	public void saveUserOrderDetail(UserOrderDetail userOrderDetail);
	
	public void updateCourierListingId( Long userOrderId,Long courierListingId);
	
	public void updateOrderIdAndCFID(Long userOrderId, Long courierFoodItemId,Long userOrderDetailId);

	public User findByUsernameAndPassword(String name, String password);
	
	public User findByUsername(String username);
	
	public Integer getOrderQuantityById(Long userOrderDetailId);


}
