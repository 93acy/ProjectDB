package com.example.projectdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectdb.model.CourierListing;
import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.service.CourierListingService;
import com.example.projectdb.service.HawkerListingService;


@Controller
public class DashboardController {	
	
	@Autowired
	private HawkerListingService hs;
	
	@Autowired
	private CourierListingService cs;
	
	
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }
	
	@GetMapping("/")
	public String listAll(Model model) {
		List<HawkerListing> listHawkers = hs.findAll();
		model.addAttribute("listHawkers", listHawkers);
		List<CourierListing> listCouriers = cs.findAll();
		model.addAttribute("listCouriers", listCouriers);
		
		return "index";
	}
	
//	@GetMapping("/")
//	public String listCouriers(Model model) {
//		List<CourierListing> listCouriers = cs.findAll();
//		model.addAttribute("listCouriers", listCouriers);
//		
//		return "index";
//	}

}