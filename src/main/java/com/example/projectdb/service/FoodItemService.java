package com.example.projectdb.service;

import com.example.projectdb.model.FoodItem;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FoodItemService {

    public List<FoodItem> findAll();

    public FoodItem addFoodItem (FoodItem newFoodItem);

    public FoodItem updateFoodItem (FoodItem foodItem);

    public void deleteFoodItem(Long id);
}
