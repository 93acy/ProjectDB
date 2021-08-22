package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.FoodItem;
import com.example.projectdb.repo.FoodItemRepository;
import com.example.projectdb.repo.HawkerListingRepository;
import java.util.List;

@RestController

public class CourierController {
	
	@Autowired
	HawkerListingRepository hrepo;
	
	@Autowired
	FoodItemRepository frepo;
	
	
	@RequestMapping("/hawkerlisting/All")
	public ResponseEntity<ArrayList<ArrayList<String>>> selectHawker(){
		
		
		ArrayList<ArrayList<String>> hl = (ArrayList<ArrayList<String>>)hrepo.findHawker();	
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(hl,HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/courier/hawker/{id}")	
	public ResponseEntity<ArrayList<ArrayList<String>>> viewFoodItem(@PathVariable("id") Long HawkerId){
	
		ArrayList<ArrayList<String>> food = (ArrayList<ArrayList<String>>)hrepo.findFoodItemByHawkerId(HawkerId);
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(food,HttpStatus.OK);
	}
	
	@RequestMapping("/courier/food")
	public ResponseEntity<String> createFood(@RequestBody FoodItem newFoodItem){
		
		List<FoodItem> foodItems = frepo.findAll();
		
		for(FoodItem f:foodItems) {
			if(f.getName()==newFoodItem.getName()) {
				return new ResponseEntity<String>("FAILED",HttpStatus.BAD_REQUEST);
			}
		}
		
		frepo.saveAndFlush(newFoodItem);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}


}

