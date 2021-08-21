package com.example.projectdb.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.HawkerListing;

public interface HawkerListingRepository extends JpaRepository<HawkerListing, Long>{

	@Query(value="SELECT id,name,address, postal_code,stall_no from hawker_listing",nativeQuery = true)
	public ArrayList<ArrayList<String>> findHawker();

	@Query(value="SELECT id,name FROM food_item f WHERE hawker_listing_id = :id",nativeQuery = true)
	public ArrayList<ArrayList<String>> findFoodItemByHawkerId(@Param("id") Long HawkerId);


}
