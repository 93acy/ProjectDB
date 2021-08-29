package com.example.projectdb.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.UserOrder;

public interface UserOrderService {
	
	public ArrayList<ArrayList<String>> getUserOrderId(Long userId);
	
	public void updateUserOrderStatus(Long userOrderId,String status);

	public ArrayList<ArrayList<String>> findUserOrder();

	public double orderSum();

	public ArrayList<ArrayList<String>> findOrderDataByUserId(Long userId);
	

	public void updateCourierListingIdAndUserId(Long userOrderId,Long courierListingId,Long userId);


	public ArrayList<ArrayList<String>> findCourierPickupDetailsByCourierListingId( Long userOrderId);


	public ArrayList<ArrayList<String>> findUserOrderFoodItemByUserOrderId(Long userOrderId);
	
	public List<List<String>> findByCourierListingId(Long id);
	
	public List<List<String>> findUserDetailsByCourierListingId(Long id);

}
