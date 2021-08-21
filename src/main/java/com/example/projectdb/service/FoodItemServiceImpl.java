package com.example.projectdb.service;

import com.example.projectdb.model.FoodItem;
import com.example.projectdb.repo.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
    private FoodItemRepository fooditemrepo;


    @Override
    public List<FoodItem> findAll() {
        return fooditemrepo.findAll();
    }

    @Override
    public FoodItem addFoodItem(FoodItem newFoodItem) {

        return fooditemrepo.saveAndFlush(newFoodItem);
    }

    @Override

    public FoodItem updateFoodItem(FoodItem foodItem) {
        return fooditemrepo.saveAndFlush(foodItem);
    }

    @Override
    public void deleteFoodItem(Long id){

    }
}

