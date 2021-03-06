package com.example.projectdb.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.CourierFoodItemDetails;

public interface CourierFoodItemDetailRepository extends JpaRepository<CourierFoodItemDetails, Long> {
	
	@Modifying
	@Transactional
	@Query(value="UPDATE courier_food_item_details SET food_item_id =:foodId WHERE id=:id", nativeQuery=true)
	public void updateCourierDetailId(@Param("foodId") Long foodId,@Param("id") Long courierDetailId);
	
	
	@Modifying
	@Transactional
	@Query(value="UPDATE courier_food_item_details SET courier_listing_id =:courierListingId,total_quantity=0 "
			+ "WHERE id=:courierDetailId", nativeQuery=true)
	public void updateCourieListingId(@Param("courierDetailId") Long courierDetailId,
			@Param("courierListingId") Long courierListingId);
	
	
	@Query(value="select total_quantity from courier_food_item_details where id=:courierFoodItemDetailId",nativeQuery=true)
	public Integer getTotalQuantityById(@Param("courierFoodItemDetailId") Long courierFoodItemDetailId);
	
	@Modifying
	@Transactional
	@Query(value="update courier_food_item_details set total_quantity = :newTotalQuantity "
			+ "where id=:courierFoodItemDetailId",nativeQuery=true)
	public Integer updateTotalQuantityById(@Param("courierFoodItemDetailId") Long courierFoodItemDetailId,
			@Param("newTotalQuantity")Integer newTotalQuantity);


}
