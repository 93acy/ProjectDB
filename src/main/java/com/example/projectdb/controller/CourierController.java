package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.CourierFoodItemDetails;
import com.example.projectdb.model.FoodItem;
import com.example.projectdb.repo.CoureirFoodItemDetailRepository;
import com.example.projectdb.repo.FoodItemRepository;
import com.example.projectdb.repo.HawkerListingRepository;

@RestController

public class CourierController {
	
	@Autowired
	HawkerListingRepository hrepo;
	
	@Autowired
	FoodItemRepository frepo;
	
	@Autowired
	CoureirFoodItemDetailRepository cfrepo;
	
	
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
	
//	@RequestMapping("/courier/food")
//	public ResponseEntity<String> createFood(@RequestBody FoodItem newFoodItem){
//		
//		List<FoodItem> foodItems = frepo.findAll();
//		
//		for(FoodItem f:foodItems) {
//			if(f.getName()==newFoodItem.getName()) {
//				return new ResponseEntity<String>("FAILED",HttpStatus.BAD_REQUEST);
//			}
//		}
//		
//		//frepo.save(newFoodItem);
//		//frepo.updateHawkerId(newFoodItem.getName(),newFoodItem.getHawkerListing().getId());
//		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
//	}
	
	@RequestMapping("/courier/food")
	public ResponseEntity<String> createFood(@RequestBody FoodItem newFoodItem, @RequestParam Long hawkerId){
		
		List<FoodItem> foodItems = frepo.findAll();
		
		for(FoodItem f:foodItems) {
			if(f.getName()==newFoodItem.getName()) {
				return new ResponseEntity<String>("FAILED",HttpStatus.BAD_REQUEST);
			}
		}
		
		frepo.save(newFoodItem);
		frepo.updateHawkerId(newFoodItem.getName(),hawkerId);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}
	
	
	@RequestMapping("/courier/foodItemDetail")
	public ResponseEntity<String> createFoodItemDetails
	(@RequestBody List<CourierFoodItemDetails> courierFoodItemDetails, @RequestParam List<Long> foodIds){
		
		
		for(int i=0; i < courierFoodItemDetails.size();i++) {
			cfrepo.save(courierFoodItemDetails.get(i));
			cfrepo.updateCourierDetailId(foodIds.get(i), courierFoodItemDetails.get(i).getId());
		}
				
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}



}

