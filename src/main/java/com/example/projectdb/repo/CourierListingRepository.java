package com.example.projectdb.repo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.CourierListing;

public interface CourierListingRepository extends JpaRepository<CourierListing, Long> {
	
	@Query("select c.id,c.pickupTime,c.hawkerListing.name,c.hawkerListing.locationArea,"
			+ "c.pickupLocation,c.orderBeforeTime,c.hawkerListing.id from CourierListing c")
	public ArrayList<ArrayList<String>> findCourierListing();
	
	@Query("SELECT f.id,f.name,f.category,f.description,cd.pricePerUnit,cd.id "
			+ "FROM CourierListing c, CourierFoodItemDetails cd, FoodItem f "
			+ "WHERE c.id=:id AND f.hawkerListing.id=:hawkerId")
	public ArrayList<ArrayList<String>> findFoodItemByCourierListingId(
			@Param("id") Long courierListingId,@Param("hawkerId") Long hawkerId);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE courier_listing SET hawker_listing_id =:hawkerId WHERE id=:id", nativeQuery=true)
	public void updateHawkerListingId(@Param("id") Long courierListingId,@Param("hawkerId") Long hawkerId);



	@Query("SELECT c.id FROM CourierListing c")
	public List<Long> findAllCourierListingId();
	
	//@Query("SELECT cd.foodItem.name FROM CourierListingDetails cd WHERE id = :id")
	//public String findFoodNameById(@Param("id") Long Id);
	
	@Query("SELECT cd.courierListing.id, cd.foodItem.name, cd.pricePerUnit, cd.totalQuantity FROM CourierFoodItemDetails cd WHERE cd.courierListing.id = :id")
	//@Query("cd.pricePerUnit, cd.totalQuantity FROM CourierFoodItemDetails cd WHERE cd.courierListing.id = :id")
	public List<List<String>> findCourierListingDetailsByCourierListingId(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CourierFoodItemDetails cd WHERE cd.courierListing.id = :Id")
	public void deletecourierListingDetail(@Param("Id") Long Id);
	
	//@Modifying
	//@Transactional
	//@Query("DELETE FROM FoodItem f WHERE f.CourierFoodItemDetails.id = :id")
	//public void deletecourierListingFoodItem(@Param("id") Long id);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CourierListing c WHERE c.id = :Id")
	public void deletecourierListing(@Param("Id") Long Id);
	
	@Query("SELECT cd.id FROM CourierFoodItemDetails cd WHERE cd.courierListing.id = :Id")
	public List<Long> getCourierListingDetailsIdByCourierListingId(@Param("Id") Long Id);
}
