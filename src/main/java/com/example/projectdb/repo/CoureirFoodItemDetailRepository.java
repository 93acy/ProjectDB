package com.example.projectdb.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.CourierFoodItemDetails;

public interface CoureirFoodItemDetailRepository extends JpaRepository<CourierFoodItemDetails, Long> {
	
	@Modifying
	@Transactional
	@Query(value="UPDATE courier_food_item_details SET food_item_id =:foodId WHERE id=:id", nativeQuery=true)
	public void updateCourierDetailId(@Param("foodId") Long foodId,@Param("id") Long courierDetailId);

}
