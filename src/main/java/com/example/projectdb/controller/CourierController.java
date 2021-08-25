package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.Collection;
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
import com.example.projectdb.model.CourierListing;
import com.example.projectdb.model.FoodItem;
import com.example.projectdb.repo.CoureirFoodItemDetailRepository;
import com.example.projectdb.repo.CourierListingRepository;
import com.example.projectdb.repo.FoodItemRepository;
import com.example.projectdb.repo.HawkerListingRepository;

@RestController

public class CourierController {
	
	@Autowired
	HawkerListingRepository hrepo;
	
	@Autowired
	CourierListingRepository crepo;
	
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
	public ResponseEntity<ArrayList<String>> createFoodItemDetails
	(@RequestBody List<CourierFoodItemDetails> courierFoodItemDetails, @RequestParam List<Long> foodIds){
		
		ArrayList<String> courierFoodItemDetailIds = new ArrayList<>();
		
		
		for(int i=0; i < courierFoodItemDetails.size();i++) {
			cfrepo.saveAndFlush(courierFoodItemDetails.get(i));
			cfrepo.updateCourierDetailId(foodIds.get(i), courierFoodItemDetails.get(i).getId());
			courierFoodItemDetailIds.add(courierFoodItemDetails.get(i).getId().toString());
		}				
				
		return new ResponseEntity<ArrayList<String>> (courierFoodItemDetailIds,HttpStatus.OK);
	}
	
	
//	@RequestMapping("/courier/foodItemDetail")
//	public ResponseEntity<String> createFoodItemDetails
//	(@RequestBody List<CourierFoodItemDetails> courierFoodItemDetails, @RequestParam List<Long> foodIds){
//
//		for(int i=0; i < courierFoodItemDetails.size();i++) {
//			cfrepo.save(courierFoodItemDetails.get(i));
//			cfrepo.updateCourierDetailId(foodIds.get(i), courierFoodItemDetails.get(i).getId());
//		}				
//				
//		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
//	}
	
	
	
	@RequestMapping("/courier/courierListing")
	public ResponseEntity<String> createCourierListing(@RequestBody CourierListing CourierListing,
			@RequestParam ArrayList<String> courierFoodItemDetailIds,
			@RequestParam ArrayList<String> FoodID){

		crepo.save(CourierListing);
		Long courierFoodItemDetailId;
		Long foodId;
		FoodItem food;
		
		for(int i=0; i < courierFoodItemDetailIds.size();i++) {
			
			foodId = Long.parseLong(FoodID.get(i));
			courierFoodItemDetailId = Long.parseLong(courierFoodItemDetailIds.get(i));
			
			//create courier listing object
			cfrepo.updateCourieListingId(courierFoodItemDetailId,CourierListing.getId());
			
			//update hawker id
			food=frepo.findFoodItemById(foodId);
			crepo.updateHawkerListingId(CourierListing.getId(), food.getHawkerListing().getId());
			
		}
		
		
				
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}
	


}

