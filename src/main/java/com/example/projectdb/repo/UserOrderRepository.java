package com.example.projectdb.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
	
	@Modifying
	@Transactional
	@Query(value="update user_order set courier_listing_id = :courierListingId, "
			+ "user_order_status = 'Pending to receive' where id = :userOrderId",
			nativeQuery=true)
	public void updateCourierListingId(@Param("userOrderId") Long userOrderId,
			@Param("courierListingId") Long courierListingId);
	
//	@Query(value="update user_order set courier_listing_id = :courierListingId "
//			+ "where id = :userOrderId",
//			nativeQuery=true)
//	public void updateCourierListingId(@Param("userOrderId") Long userOrderId,
//			@Param("courierListingId") Long courierListingId);


}
