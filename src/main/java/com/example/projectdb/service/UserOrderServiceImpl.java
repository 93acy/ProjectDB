package com.example.projectdb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.UserOrder;
import com.example.projectdb.repo.UserOrderRepository;


@Service
public class UserOrderServiceImpl implements UserOrderService {
	
	
	@Autowired 
	private UserOrderRepository uorepo;
	
	@Override
	public ArrayList<ArrayList<String>> getUserOrderId(Long userId){
		return uorepo.findOrderDataByUserId(userId);
	 }
	 
	 @Override
	 public void updateUserOrderStatus(Long userOrderId,String status) {
		 uorepo.updateUserOrderStatus(userOrderId, status);
	 }
	    @Override
		public ArrayList<ArrayList<String>> findUserOrder(){
			return uorepo.findUserOrder();
		}
		
		@Override
		public double orderSum() {
			return uorepo.orderSum();
		}
		
		@Override
		public ArrayList<ArrayList<String>> findOrderDataByUserId(Long userId){
			return uorepo.findOrderDataByUserId(userId);
		}
		
		@Override
		public void updateCourierListingIdAndUserId(Long userOrderId,Long courierListingId,Long userId) {
			uorepo.updateCourierListingIdAndUserId(userOrderId,courierListingId,userId);
		}
		

		@Override
		public ArrayList<ArrayList<String>> findCourierPickupDetailsByCourierListingId( Long userOrderId){
			return uorepo.findCourierPickupDetailsByCourierListingId(userOrderId);
		}

		@Override
		public ArrayList<ArrayList<String>> findUserOrderFoodItemByUserOrderId(Long userOrderId){
			return uorepo.findUserOrderFoodItemByUserOrderId(userOrderId);
		}

}
