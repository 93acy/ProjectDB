package com.example.projectdb.repo;

import com.example.projectdb.model.HawkerListing;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HawkerListingRepository extends JpaRepository<HawkerListing, Integer>{
	
	@Query("SELECT hl.name FROM HawkerListing hl WHERE hl.name = :keyword ") 
	public List<String> findHawkerListingNameByKeyword(@Param("keyword")String keyword);
	
	
	
	
	
	@Query(value="SELECT id AS 'Id',address AS 'Address', postal_code AS 'PostalCode',stall_no AS 'StallNo' from hawker_listing",nativeQuery = true)
	public ArrayList<ArrayList<String>> findHawker();

	@Query(value="SELECT id,name FROM food_item f WHERE hawker_listing_id = :id",nativeQuery = true)
	public ArrayList<ArrayList<String>> findFoodItemByHawkerId(@Param("id") Long HawkerId);
	
	
	
	

	
	

	@Transactional
	@Query("DELETE FROM HawkerListing h")
	public void deleteall();

}
