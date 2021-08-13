package com.example.projectdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.HawkerListing;

public interface HawkerListingRepository extends JpaRepository<HawkerListing, Long> {

	
//	 @Query("SELECT h FROM HawkerListing h WHERE "
//	            + "CONCAT(h.name,h.id)"
//	            + "LIKE %:keyword%")
//	    List<HawkerListing> findByKeyword(@Param("keyword") String keyword);

//	public HawkerListing findHawkerListingById();


}
