package com.example.projectdb.service;

import com.example.projectdb.model.CourierFoodItemDetails;

public interface CourierFoodItemDetailService {

	public void saveAndFlush(CourierFoodItemDetails courierFoodItemDetails);

	public void updateCourierDetailId(Long long1, Long id);

	public void updateCourierListingId(Long courierFoodItemDetailId, Long id);
	
	public Integer getTotalQuantityById(Long courierFoodItemDetailId);
	
	public Integer updateTotalQuantityById(Long courierFoodItemDetailId ,Integer newTotalQuantity);



}
