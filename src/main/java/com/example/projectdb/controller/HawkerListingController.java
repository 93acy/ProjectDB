package com.example.projectdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.services.HawkerService;



@RestController
public class HawkerListingController {
	
	@Autowired 
	private HawkerService hservice;
	
	
	@RequestMapping("/viewhawkerlisting") 
    public void ViewHawkerListing(Model model, String keyword){
        if (keyword != null) {
        	model.addAttribute("hawkerListings", hservice.findByKeyword(keyword));
        }
        else {
        List <HawkerListing> hawkerListings = hservice.findAll();
        model.addAttribute("hawkerListings", hawkerListings);
        }
	}
	



}
