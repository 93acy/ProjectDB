package com.example.projectdb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.projectdb.model.CourierListing;
import com.example.projectdb.model.CourierListingDetails;

public interface CourierListingRepository extends JpaRepository<CourierListing, Long> {

	
	
	
	@Query("SELECT c.hawkerListing.name FROM CourierListing c WHERE c.id = :id")
	public String findHawkerNameByCourierListingId(@Param("id") Long Id);
	
	@Query("SELECT cd FROM CourierListingDetails cd WHERE cd.courierListing.id = :id")
	public List<CourierListingDetails> findByCourierListingId(@Param("id") Long Id);
	
	@Query("SELECT c.id FROM CourierListing c")
	public List<Long> findAllCourierListingId();
	
	@Query("SELECT cd.foodItem.name FROM CourierListingDetails cd WHERE id = :id")
	public String findFoodNameById(@Param("id") Long Id);
	
	@Query("SELECT cd.courierListing.id, cd.foodItem.name, cd.pricePerUnit, cd.totalQuantity FROM CourierListingDetails cd WHERE cd.courierListing.id = :id")
	public List<List<String>> findCourierListingDetailsByCourierListingId(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CourierListingDetails cd WHERE cd.courierListing.id = :Id")
	public void deletecourierListingDetail(@Param("Id") Long Id);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM FoodItem f WHERE f.courierListingDetails.id = :id")
	public void deletecourierListingFoodItem(@Param("id") Long id);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CourierListing c WHERE c.id = :Id")
	public void deletecourierListing(@Param("Id") Long Id);
	
	@Query("SELECT cd.id FROM CourierListingDetails cd WHERE cd.courierListing.id = :Id")
	public List<Long> getCourierListingDetailsIdByCourierListingId(@Param("Id") Long Id);
	
}
