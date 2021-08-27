package com.example.projectdb.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.UserOrderDetail;

public interface UserOrderDetailRepository extends JpaRepository<UserOrderDetail, Long> {
	
	
	@Modifying
	@Transactional
	@Query(value="update user_order_detail set user_order_id = :userOrderId, "
			+ "courier_food_item_details_id = :courierFoodItemId where id = :userOrderDetailId",
			nativeQuery=true)
	public void updateOrderIdAndCFID(@Param("userOrderId") Long userOrderId,
			@Param("courierFoodItemId") Long courierFoodItemId,@Param("userOrderDetailId")Long userOrderDetailId);

}
