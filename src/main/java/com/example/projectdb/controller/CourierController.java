package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.CourierFoodItemDetails;
import com.example.projectdb.model.CourierListing;
import com.example.projectdb.model.FoodItem;
import com.example.projectdb.repo.CourierFoodItemDetailRepository;
import com.example.projectdb.repo.CourierListingRepository;
import com.example.projectdb.repo.FoodItemRepository;
import com.example.projectdb.repo.HawkerListingRepository;
import com.example.projectdb.service.CourierFoodItemDetailService;
import com.example.projectdb.service.CourierListingService;
import com.example.projectdb.service.FoodItemService;
import com.example.projectdb.service.HawkerListingService;

@RestController

public class CourierController {
	
	@Autowired
	HawkerListingService hservice;;
	
	@Autowired
	CourierListingService clservice;
	
	@Autowired
	CourierFoodItemDetailService cfservice;
	
	@Autowired
	FoodItemService fservice;
	
	
	
	@RequestMapping("/hawkerlisting/All")
	public ResponseEntity<ArrayList<ArrayList<String>>> selectHawker(){
		
		
		ArrayList<ArrayList<String>> hl = (ArrayList<ArrayList<String>>)hservice.findHawker();	
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(hl,HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/courier/hawker/{id}")	
	public ResponseEntity<ArrayList<ArrayList<String>>> viewFoodItem(@PathVariable("id") Long HawkerId){
	
		ArrayList<ArrayList<String>> food = (ArrayList<ArrayList<String>>)hservice.findFoodItemByHawkerId(HawkerId);
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(food,HttpStatus.OK);
	}
	
	
	@RequestMapping("/courier/food")
	public ResponseEntity<String> createFood(@RequestBody FoodItem newFoodItem, @RequestParam Long hawkerId){
		
		List<FoodItem> foodItems = fservice.findAll();
		
		for(FoodItem f:foodItems) {
			if(f.getName()==newFoodItem.getName()) {
				return new ResponseEntity<String>("FAILED",HttpStatus.BAD_REQUEST);
			}
		}
		
		fservice.save(newFoodItem);
		fservice.updateHawkerId(newFoodItem.getName(),hawkerId);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}
	
	
	@RequestMapping("/courier/foodItemDetail")
	public ResponseEntity<ArrayList<String>> createFoodItemDetails
	(@RequestBody List<CourierFoodItemDetails> courierFoodItemDetails, @RequestParam List<Long> foodIds){
		
		ArrayList<String> courierFoodItemDetailIds = new ArrayList<>();
		
		
		for(int i=0; i < courierFoodItemDetails.size();i++) {
			cfservice.saveAndFlush(courierFoodItemDetails.get(i));
			cfservice.updateCourierDetailId(foodIds.get(i), courierFoodItemDetails.get(i).getId());
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

		clservice.save(CourierListing);
		Long courierFoodItemDetailId;
		Long foodId;
		FoodItem food;
		
		for(int i=0; i < courierFoodItemDetailIds.size();i++) {
			
			foodId = Long.parseLong(FoodID.get(i));
			courierFoodItemDetailId = Long.parseLong(courierFoodItemDetailIds.get(i));
			
			//create courier listing object
			cfservice.updateCourierListingId(courierFoodItemDetailId,CourierListing.getId());
			
			//update hawker id
			food=fservice.findFoodItemById(foodId);
			clservice.updateHawkerListingId(CourierListing.getId(), food.getHawkerListing().getId());
			
		}
		
		
				
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/courier/viewCourierListings")
	public ResponseEntity<List<List<List<String>>>> viewCourierListings(){


		List<Long> courierListingIds = clservice.findAllCourierListingId();

		List<List<String>> courierListings = new ArrayList<>();
		List<List<List<String>>> CourierListings = new ArrayList<>();
		for(Long id: courierListingIds) {

			courierListings = clservice.findCourierListingDetailsByCourierListingId(id);
			CourierListings.add(courierListings);
		}

		
		return new ResponseEntity<List<List<List<String>>>>(CourierListings, HttpStatus.OK);
	}
	
	@RequestMapping("/courier/cancelCourierListing/{id}")
	public ResponseEntity<String> cancelCourierListing(@PathVariable String id){
		long Id = Long.parseLong(id);
		//List<Long> courierListingDetailsId = clservice.getCourierListingDetailsIdByCourierListingId(Id);
		/*for(Long ids : courierListingDetailsId) {
			clservice.deletecourierListingFoodItem(ids);
		}*/

		clservice.deletecourierListingDetail(Id);
		clservice.deletecourierListing(Id);
		return new ResponseEntity<String>("successful", HttpStatus.OK);
	}
	


}

