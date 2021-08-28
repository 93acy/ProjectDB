package com.example.projectdb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectdb.model.CourierListing;
import com.example.projectdb.repo.CourierListingRepository;


@Service
public class CourierListingServiceImpl implements CourierListingService{
	
	@Autowired
	private CourierListingRepository crepo;

	@Override
	public void save(CourierListing courierListing) {
		crepo.saveAndFlush(courierListing);	
	}

	@Override
	public void updateHawkerListingId(Long id, Long id2) {
		crepo.updateHawkerListingId(id, id2);
	}

	@Override
	public ArrayList<ArrayList<String>> findCourierListing() {
		return crepo.findCourierListing();
	}

	@Override
	public ArrayList<ArrayList<String>> findFoodItemByCourierListingId(Long courierListingId, Long hawkerId) {
		return crepo.findFoodItemByCourierListingId(courierListingId, hawkerId);
	}
	
	@Override
	public List<CourierListing> findAll() {
		return crepo.findAll();
	}
	
	
	public List<Long> findAllCourierListingId(){
		return crepo.findAllCourierListingId();
	};
	public List<List<String>> findCourierListingDetailsByCourierListingId(Long id){
		return crepo.findCourierListingDetailsByCourierListingId(id);
	};
	public List<Long> getCourierListingDetailsIdByCourierListingId(Long Id){
		return crepo.getCourierListingDetailsIdByCourierListingId(Id);
	};

	public void deletecourierListingDetail(Long Id) {
		crepo.deletecourierListingDetail(Id);
	};
	public void deletecourierListing(Long Id) {
		crepo.deletecourierListing(Id);
	};
	
	@Override
	public String findHawkerNameByCLid(Long courierListingId) {
		
		return crepo.findHawkerNameByCLid(courierListingId);
	}

	

}
