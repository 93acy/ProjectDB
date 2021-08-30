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
	
	@Query("SELECT c.id FROM CourierListing c")
	public List<Long> findAllCourierListingId();
	
	
	@Query("SELECT cd.courierListing.id, cd.foodItem.name, cd.pricePerUnit, cd.totalQuantity FROM CourierFoodItemDetails cd WHERE cd.courierListing.id = :id")
	public List<List<String>> findCourierListingDetailsByCourierListingId(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CourierFoodItemDetails cd WHERE cd.courierListing.id = :Id")
	public void deletecourierListingDetail(@Param("Id") Long Id);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CourierListing c WHERE c.id = :Id")
	public void deletecourierListing(@Param("Id") Long Id);
	
	@Query("SELECT cd.id FROM CourierFoodItemDetails cd WHERE cd.courierListing.id = :Id")
	public List<Long> getCourierListingDetailsIdByCourierListingId(@Param("Id") Long Id);
	
	@Query("SELECT cl.hawkerListing.name FROM CourierListing cl WHERE id = :courierListingId")
	public String findHawkerNameByCLid(@Param("courierListingId") Long courierListingId);
	
	@Modifying
	@Transactional
	@Query("UPDATE CourierListing c SET c.courierOrderStatus = 'Close' WHERE c.id = :Id")
	public void updatecourierListing(@Param("Id")Long Id);

	@Modifying
	@Transactional
	@Query(value="UPDATE courier_listing  SET user_id =:userId WHERE id = :CourierListing",nativeQuery=true)
	public void updateCourierId(@Param("userId")Long userId, @Param("CourierListing") Long CourierListing);

	@Query("SELECT c.id FROM CourierListing c WHERE c.user.id = :Id")
	public List<Long> findCourierListingByUserId(@Param("Id") Long userId);


}
