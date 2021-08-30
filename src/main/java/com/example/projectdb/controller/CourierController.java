package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.example.projectdb.service.UserOrderService;
import com.example.projectdb.service.UserService;

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
	
	@Autowired
	UserOrderService uoservice;
	
	@Autowired
	UserService uService;


	
//	@RequestMapping("/hawkerlisting/All")
//	public ResponseEntity<ArrayList<ArrayList<String>>> selectHawker(){
//
//
//		ArrayList<ArrayList<String>> hl = (ArrayList<ArrayList<String>>)hservice.findHawker();
//
//		return new ResponseEntity<ArrayList<ArrayList<String>>>(hl,HttpStatus.OK);
//	}
	
	
	
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
	
	
	
	
	
	@RequestMapping("/courier/courierListing")
	public ResponseEntity<String> createCourierListing(@RequestBody CourierListing CourierListing,
			@RequestParam ArrayList<String> courierFoodItemDetailIds,
			@RequestParam ArrayList<String> FoodID){

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
	            .getPrincipal();
	    String username = userDetails.getUsername();
	    Long userId = uService.findIdByUsername(username);

		clservice.save(CourierListing);
		clservice.updateCourierId(userId,CourierListing.getId());
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

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				   .getPrincipal();
		String username = userDetails.getUsername();
		Long userId = uService.findIdByUsername(username);

		List<Long> courierListingIds = clservice.findCourierListingByUserId(userId);

		//List<Long> courierListingIds = clservice.findAllCourierListingId();

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

		clservice.deletecourierListingDetail(Id);
		clservice.deletecourierListing(Id);
		return new ResponseEntity<String>("successful", HttpStatus.OK);
	}
	
	@RequestMapping("/courier/updateCourierListing")
	public ResponseEntity<String> updateCourierListing(@RequestBody String id){
		String a = id.substring(1,2);
		long Id = Long.parseLong(a);

		clservice.updatecourierListing(Id);
		return new ResponseEntity<String>("successful", HttpStatus.OK);
	}
	
	@RequestMapping("/courier/viewCourierListingDetails/{id}")
	public ResponseEntity<List<List<String>>> viewCourierListingDetails(@PathVariable("id") String id){
		long Id = Long.parseLong(id);
		List<List<String>> userOrder =  uoservice.findByCourierListingId(Id);
		return new ResponseEntity<List<List<String>>>(userOrder, HttpStatus.OK);
	}
	
	@RequestMapping("/courier/viewCourierListingDetailInfo/{id}")
	public ResponseEntity<List<List<String>>> viewCourierListingDetailInfo(@PathVariable("id") String id){
		long Id = Long.parseLong(id);
		List<List<String>> userOrderDetails = uoservice.findUserDetailsByCourierListingId(Id);
		return new ResponseEntity<List<List<String>>>(userOrderDetails, HttpStatus.OK);
	}
	

}

