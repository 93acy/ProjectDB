package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.repo.HawkerListingRepository;

@RestController

public class CourierController {
	
	@Autowired
	HawkerListingRepository hrepo;
	
	
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


}

