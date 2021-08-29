package com.example.projectdb.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.HawkerListing;

public interface HawkerListingRepository extends JpaRepository<HawkerListing, Long>{

	@Query(value="SELECT id,name,address,location_area, postal_code,stall_no from hawker_listing",nativeQuery = true)
	public ArrayList<ArrayList<String>> findHawker();

	@Query(value="SELECT id,name,category,description FROM food_item f WHERE hawker_listing_id = :id",nativeQuery = true)
	public ArrayList<ArrayList<String>> findFoodItemByHawkerId(@Param("id") Long HawkerId);

	@Query("SELECT case when count(h) >0 then true else false end from HawkerListing h where lower(h.name) = lower(:hawkerName)")
	public Boolean hawkerNameExist(@Param("hawkerName") String hawkerName);





}
