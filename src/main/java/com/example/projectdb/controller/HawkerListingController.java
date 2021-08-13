package com.example.projectdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.model.User;
import com.example.projectdb.services.HawkerService;

@RestController
public class HawkerListingController {
	
	@Autowired
	private HawkerService hservice;
	
	
	@GetMapping("/hawkerlisting/viewall") 
    public ResponseEntity<List<HawkerListing>> ViewHawkerListing(){
        List<HawkerListing> hawkerlistings = hservice.findAll();
        return new ResponseEntity<>(hawkerlistings, HttpStatus.OK);
	}


//	@GetMapping("/hawkerlisting/{id}")
//    public ResponseEntity<HawkerListing> getHawkerListingById(@PathVariable("id") Long id){
//        HawkerListing hawkerlisting = hservice.findHawkerListingById(id);
//        return new ResponseEntity<>(hawkerlisting, HttpStatus.OK);
//	}
	
	@PostMapping("/hawkerlisting/add")
	public ResponseEntity<HawkerListing> addHawkerListing(@RequestBody HawkerListing hawkerlisting){
		HawkerListing newHawkerListing = hservice.addHawkerListing(hawkerlisting);
		return new ResponseEntity<>(newHawkerListing, HttpStatus.CREATED);
	}
	
	@PutMapping("/hawkerlisting/update")
	public ResponseEntity<HawkerListing> updateHawkerListing(@RequestBody HawkerListing hawkerlisting){
		HawkerListing updateHawkerListing = hservice.updateHawkerListing(hawkerlisting);
		return new ResponseEntity<>(updateHawkerListing, HttpStatus.OK);
	}
	
	@DeleteMapping("/hawkerlisting/delete/{id}")
	public ResponseEntity<?> deleteHawkerListing(@PathVariable("id") Long id){
		hservice.deleteHawkerListing(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}



}
