package com.example.projectdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.FoodItem;
import com.example.projectdb.repo.FoodItemRepository;

@Service
public class FoodItemServiceImpl implements FoodItemService{

	@Autowired
	private FoodItemRepository frepo;
	
	@Override
	public List<FoodItem> findAll() {
		return frepo.findAll();
	}

	@Override
	public void save(FoodItem newFoodItem) {
		frepo.saveAndFlush(newFoodItem);
		
	}

	@Override
	public void updateHawkerId(String name, Long hawkerId) {
		frepo.updateHawkerId(name, hawkerId);
		
	}

	@Override
	public FoodItem findFoodItemById(Long foodId) {
		return frepo.findFoodItemById(foodId);

}
}
