package com.example.projectdb.service;

import com.example.projectdb.model.HawkerListing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface HawkerListingService {

    public List<HawkerListing> findAll();

    public HawkerListing addHawkerListing(HawkerListing newHawkerListing);

    public HawkerListing updateHawkerListing(HawkerListing hawkerListing);

    public void deleteHawkerListing(Long id);

	public ArrayList<ArrayList<String>> findHawker();

	public ArrayList<ArrayList<String>> findFoodItemByHawkerId(Long hawkerId);
}
