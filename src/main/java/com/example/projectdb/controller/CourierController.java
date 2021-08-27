package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.CourierListing;
import com.example.projectdb.model.CourierListingDetails;
import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.repo.CourierListingRepository;
import com.example.projectdb.repo.HawkerListingRepository;
import com.example.projectdb.service.CourierService;




@RestController
public class CourierController {
	
	@Autowired
	CourierService cs;
	
	
	@PostMapping("/courier/create")
	public ResponseEntity<String> createCourierListing(@RequestBody CourierListing courierListing) {
		cs.saveCourierListing(courierListing);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@GetMapping("/courier/get")
	public ResponseEntity<List<CourierListing>> viewCourierListing() {
		List<CourierListing> courierListing = cs.findAllCourierListing();
		return new ResponseEntity<List<CourierListing>>(courierListing, HttpStatus.OK);
	}
	
	@GetMapping("/courier/searchHawkerListing")
	public List<String> searchHawkerListing(@RequestParam String keyword) {
		List<String> hawkerListings = cs.findHawkerListingNameByKeyword(keyword);
		return hawkerListings;
	}
	
	
	@Autowired
	HawkerListingRepository hrepo;
	
	@Autowired
	CourierListingRepository crepo;
	
	
	/*@GetMapping("/courier/viewCourierListings")
	public ResponseEntity<List<Object>> viewCourierListings(){
		List<Object> l1 = new ArrayList<>();
		List<Object> l2 = new ArrayList<>();
		List<Object> l3 = new ArrayList<>();
		List<Object> l4 = new ArrayList<>();
		List<Object> l5 = new ArrayList<>();
		List<CourierListing> courierListing = cs.findAllCourierListing();
		Double totalFoodPrice = 0.0;
		for(CourierListing c : courierListing) {
			String hawkerName = crepo.findHawkerNameByCourierListingId(c.getId());
			l1.add(hawkerName);
			List<CourierListingDetails> details = crepo.findByCourierListingId(c.getId());
			
			for(CourierListingDetails cd : details) {
				String foodItemName = crepo.findFoodNameById(cd.getId());
				Integer totalQuantity = cd.getTotalQuantity();
				totalFoodPrice = totalFoodPrice + cd.getPricePerUnit() * cd.getTotalQuantity();
			}
			l3.add(totalFoodPrice);
			Double serviceFee = totalFoodPrice*0.1;
			Double totalPrice = totalFoodPrice + serviceFee;
			l4.add(serviceFee);
			l5.add(totalPrice);
		}
		List<Object> courierListingDetails = new ArrayList<>();
		courierListingDetails.add(l1);
		courierListingDetails.add(l2);
		courierListingDetails.add(l3);
		courierListingDetails.add(l4);
		courierListingDetails.add(l5);
		
		return new ResponseEntity<List<Object>>(courierListingDetails, HttpStatus.OK);
	}*/
	
	@GetMapping("/courier/viewCourierListings")
	public ResponseEntity<List<List<List<String>>>> viewCourierListings(){

		//List<CourierListing> courierListings = cs.findAllCourierListing();
		List<Long> courierListingIds = crepo.findAllCourierListingId();
		//List<String> courierListingIdStrings = new ArrayList<>();
		List<List<String>> courierListings = new ArrayList<>();
		List<List<List<String>>> CourierListings = new ArrayList<>();
		for(Long id: courierListingIds) {
			//courierListingIdStrings.add(id.toString());
			courierListings = crepo.findCourierListingDetailsByCourierListingId(id);
			CourierListings.add(courierListings);
		}

		
		return new ResponseEntity<List<List<List<String>>>>(CourierListings, HttpStatus.OK);
		//return new ResponseEntity<List<String>>(courierListingIdStrings, HttpStatus.OK);
	}
	
	/*@GetMapping("/courier/viewCourierListingDetails/{id}")
	public ResponseEntity<List<List<String>>> viewCourierListingDetails(@PathVariable Long id){

		List<List<String>> courierListingDetails = crepo.findCourierListingDetailsByCourierListingId(id);
		//List<Object> test = new ArrayList<>();
		//test.add(1);
		
		return new ResponseEntity<List<List<String>>>(courierListingDetails, HttpStatus.OK);
		//return new ResponseEntity<List<Object>>(test, HttpStatus.OK);
		
	}*/
	
	@RequestMapping("/courier/cancelCourierListing/{id}")
	public ResponseEntity<String> cancelCourierListing(@PathVariable String id){
		long Id = Long.parseLong(id);
		List<Long> courierListingDetailsId = crepo.getCourierListingDetailsIdByCourierListingId(Id);
		for(Long ids : courierListingDetailsId) {
			crepo.deletecourierListingFoodItem(ids);
		}

		crepo.deletecourierListingDetail(Id);
		crepo.deletecourierListing(Id);
		return new ResponseEntity<String>("successful", HttpStatus.OK);
	}
	
	
	
	
	//@Autowired
	//HawkerListingRepository hrepo;
	
	@RequestMapping("/courier/hawker")
	public ResponseEntity<ArrayList<ArrayList<String>>> selectHawker(){
		
		
		ArrayList<ArrayList<String>> hl = (ArrayList<ArrayList<String>>)hrepo.findHawker();	
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(hl,HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/courier/hawker/{id}")	
	public ResponseEntity<ArrayList<ArrayList<String>>> viewFoodItem(@PathVariable("id") Long HawkerId){
	
		ArrayList<ArrayList<String>> food = (ArrayList<ArrayList<String>>)hrepo.findFoodItemByHawkerId(HawkerId);
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(food,HttpStatus.OK);
	}
	
	
	
	
	
	
	@PostMapping("/createHawkerListing")
	public ResponseEntity<String> createHawkerListing(@RequestBody HawkerListing hawkerListing) {
		cs.save(hawkerListing);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
		//return new ResponseEntity<String>(String.format("{0}", courierListing), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteHawkerListing")
	public ResponseEntity<String> deleteHawkerListing() {
		cs.deleteall();
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		//return new ResponseEntity<String>(String.format("{0}", courierListing), HttpStatus.OK);
	}
	
	
}
