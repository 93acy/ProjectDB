package com.example.projectdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.CourierFoodItemDetails;
import com.example.projectdb.repo.CourierFoodItemDetailRepository;


@Service
public class CourierFoodItemDetailServiceImpl implements CourierFoodItemDetailService{
	
	@Autowired
	private CourierFoodItemDetailRepository cfrepo;

	@Override
	public void saveAndFlush(CourierFoodItemDetails courierFoodItemDetails) {
		cfrepo.saveAndFlush(courierFoodItemDetails);
		
	}

	@Override
	public void updateCourierDetailId(Long long1, Long id) {
		cfrepo.updateCourierDetailId(long1, id);
		
	}

	@Override
	public void updateCourierListingId(Long courierFoodItemDetailId, Long id) {
		cfrepo.updateCourieListingId(courierFoodItemDetailId, id);
		
	}
	


}
