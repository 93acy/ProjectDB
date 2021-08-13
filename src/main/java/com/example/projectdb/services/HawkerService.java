package com.example.projectdb.services;

import java.util.List;
import java.util.Optional;

import com.example.projectdb.model.HawkerListing;
import org.springframework.stereotype.Component;



public interface HawkerService {

	public List<HawkerListing> findAll();

//	public List<HawkerListing> findByKeyword(String keyword);

//	public HawkerListing findHawkerListingById(Long id);

	public HawkerListing addHawkerListing(HawkerListing hawkerlisting);

	public HawkerListing updateHawkerListing(HawkerListing hawkerlisting);

	public void deleteHawkerListing(Long id);
	
}
