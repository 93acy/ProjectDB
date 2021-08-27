package com.example.projectdb.service;

import java.util.List;

import com.example.projectdb.model.CourierListing;
import com.example.projectdb.model.HawkerListing;

public interface CourierService {
	public List<CourierListing> findAllCourierListing();
	public void saveCourierListing(CourierListing courierListing);
	public List<String> findHawkerListingNameByKeyword(String keyword);
	
	
	
	
	
	public void save(HawkerListing hawkerListing);
	public void deleteall();
}
