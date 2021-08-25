package com.example.projectdb.service;

import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.repo.HawkerListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HawkerListingServiceImpl implements HawkerListingService {
    @Autowired
    private HawkerListingRepository hlrepo;


    @Override
    public List<HawkerListing> findAll() {
        return hlrepo.findAll();
    }

    @Override
    public HawkerListing addHawkerListing(HawkerListing newHawkerListing) {

        return hlrepo.saveAndFlush(newHawkerListing);
    }

    @Override

    public HawkerListing updateHawkerListing(HawkerListing hawkerListing) {
        return hlrepo.saveAndFlush(hawkerListing);
    }

    @Override
    public void deleteHawkerListing(Long id){

    }

	@Override
	public ArrayList<ArrayList<String>> findHawker() {
		return hlrepo.findHawker();
	}

	@Override
	public ArrayList<ArrayList<String>> findFoodItemByHawkerId(Long hawkerId) {
		return hlrepo.findFoodItemByHawkerId(hawkerId);
	}
}
