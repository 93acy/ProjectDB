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

//	@Override
//	public List<HawkerListing> findByKeyword(String keyword) {
//		return hrepo.findByKeyword(keyword);
//	}

//	@Override
//	public HawkerListing findHawkerListingById(Long id) {
//		return hrepo.findHawkerListingById();
//	}

	@Override
	public HawkerListing addHawkerListing(HawkerListing hawkerlisting) {
		return hrepo.save(hawkerlisting);
	}

	@Override
	public HawkerListing updateHawkerListing(HawkerListing hawkerlisting) {
		return hrepo.save(hawkerlisting);
	}

	@Override
	public void deleteHawkerListing(Long id) {
		hrepo.deleteById(id);
		
	}
	



}
