package com.example.projectdb.repo;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.CourierListing;

public interface CourierListingRepository extends JpaRepository<CourierListing, Long> {
	
	@Query("select c.id,c.pickupTime,c.hawkerListing.name,c.hawkerListing.locationArea,"
			+ "c.pickupLocation,c.orderBeforeTime,c.hawkerListing.id from CourierListing c where c.courierOrderStatus='Open'")
	public ArrayList<ArrayList<String>> findCourierListing();
	
	@Query("SELECT cd.foodItem.id,cd.foodItem.name,cd.foodItem.category,cd.foodItem.description,cd.pricePerUnit,cd.id "
			+ "FROM CourierFoodItemDetails cd "
			+ "WHERE cd.courierListing.id=:id AND cd.foodItem.hawkerListing.id=:hawkerId")
	public ArrayList<ArrayList<String>> findFoodItemByCourierListingId(
			@Param("id") Long courierListingId,@Param("hawkerId") Long hawkerId);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE courier_listing SET hawker_listing_id =:hawkerId WHERE id=:id", nativeQuery=true)
	public void updateHawkerListingId(@Param("id") Long courierListingId,@Param("hawkerId") Long hawkerId);


}
