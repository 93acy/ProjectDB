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
public abstract class UserOrderServiceImpl implements UserOrderService {
	
	
	@Autowired 
	private UserOrderRepository uorepo;

	 public ArrayList<ArrayList<String>> getUserOrderId(Long userId){
		 return uorepo.findOrderDataByUserId(userId);
	 }
	 
	 public void updateUserOrderStatus(Long userOrderId,String status) {
		 uorepo.updateUserOrderStatus(userOrderId, status);
	 }
	 
		public ArrayList<ArrayList<String>> findUserOrder(){
			return uorepo.findUserOrder();
		}

		public double orderSum() {
			return uorepo.orderSum();
		}

		public ArrayList<ArrayList<String>> findOrderDataByUserId(Long userId){
			return uorepo.findOrderDataByUserId(userId);
		}
		
		public void updateCourierListingIdAndUserId(Long userOrderId,Long courierListingId,Long userId) {
			uorepo.updateCourierListingIdAndUserId(userOrderId,courierListingId,userId);
		}
		


		public ArrayList<ArrayList<String>> findCourierPickupDetailsByCourierListingId( Long userOrderId){
			return uorepo.findCourierPickupDetailsByCourierListingId(userOrderId);
		}


		public ArrayList<ArrayList<String>> findUserOrderFoodItemByUserOrderId(Long userOrderId){
			return uorepo.findUserOrderFoodItemByUserOrderId(userOrderId);
		}
	
	

}
