package com.example.projectdb.service;

import java.util.ArrayList;
import java.util.List;

import com.example.projectdb.model.CourierListing;

public interface CourierListingService {

	public void save(CourierListing courierListing);

	public void updateHawkerListingId(Long id, Long id2);

	public ArrayList<ArrayList<String>> findCourierListing();

	public ArrayList<ArrayList<String>> findFoodItemByCourierListingId(Long courierListingId, Long hawkerId);
	
	public List<CourierListing> findAll();
	
	public List<Long> findAllCourierListingId();
	
	public List<List<String>> findCourierListingDetailsByCourierListingId(Long id);
	
	public List<Long> getCourierListingDetailsIdByCourierListingId(Long Id);
	
	public void deletecourierListingDetail(Long Id);
	
	public void deletecourierListing(Long Id);
	
	public String findHawkerNameByCLid(Long courierListingId);
	
	public void updatecourierListing(Long Id);

	public List<Long> findCourierListingByUserId(Long userId);

	public void updateCourierId(Long userId, Long CourierListing);



}
