package com.example.projectdb.service;

import java.util.List;

import com.example.projectdb.model.FoodItem;

public interface FoodItemService {

	public List<FoodItem> findAll();

	public void save(FoodItem newFoodItem);

	public void updateHawkerId(String name, Long hawkerId);

	public FoodItem findFoodItemById(Long foodId);

}
