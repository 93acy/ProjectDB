package com.example.projectdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.CourierListing;
import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.repo.CourierListingRepository;
import com.example.projectdb.repo.HawkerListingRepository;

@Service
public class CourierServiceImplementation implements CourierService{
	
	@Autowired
	private CourierListingRepository clr;
	@Autowired
	private HawkerListingRepository hlr;
	
	public List<CourierListing> findAllCourierListing() {
		return clr.findAll();
	}
	
	public void saveCourierListing(CourierListing courierListing) {
		clr.save(courierListing);
	}
	
	public List<String> findHawkerListingNameByKeyword(String keyword){
		return hlr.findHawkerListingNameByKeyword(keyword);
	}
	
	
	
	

	
	public void save(HawkerListing hawkerListing) {
		hlr.save(hawkerListing);
	}
	
	public void deleteall() {
		hlr.deleteAll();
	}
}
