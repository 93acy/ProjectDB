package com.example.projectdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.service.HawkerListingService;


@Controller
public class DashboardController {	
	
	@Autowired
	private HawkerListingService hs;
	
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }
	
	@GetMapping("/")
	public String listHawkers(Model model) {
		List<HawkerListing> listHawkers = hs.findAll();
		model.addAttribute("listHawkers", listHawkers);
		
		return "index";
	}

}
