package com.example.projectdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.repository.HawkerListingRepository;


public class HawkerServiceImpl implements HawkerService{
	
	@Autowired
	private HawkerListingRepository hrepo;

	@Override
	public List<HawkerListing> findAll() {
		return hrepo.findAll();
	}

	@Override
	public List<HawkerListing> findByKeyword(String keyword) {
		return hrepo.findByKeyword(keyword);
	}



}
