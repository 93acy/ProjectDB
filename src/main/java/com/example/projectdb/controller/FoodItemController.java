package com.example.projectdb.controller;

import com.example.projectdb.model.FoodItem;
import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.service.FoodItemService;
import com.example.projectdb.service.HawkerListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooditem")
public class FoodItemController {

    @Autowired
    private FoodItemService fooditemservice;

    @GetMapping("/All")
    public ResponseEntity<List<FoodItem>> viewAllListings(){
        List<FoodItem> foodItemList= fooditemservice.findAll();
        return new ResponseEntity<>(foodItemList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFoodItem(@RequestBody FoodItem foodItem){
        fooditemservice.addFoodItem(foodItem);
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFoodItem(@RequestBody FoodItem foodItem){
        fooditemservice.updateFoodItem(foodItem);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFoodItem(@PathVariable("id") Long id){
        fooditemservice.deleteFoodItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
