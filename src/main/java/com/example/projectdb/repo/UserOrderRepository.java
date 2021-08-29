package com.example.projectdb.repo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

	@Modifying
	@Transactional
	@Query(value="update user_order set courier_listing_id =:courierListingId, "
			+ "user_order_status = 'Pending to receive',user_id=:userId where id =:userOrderId",
			nativeQuery=true)
	public void updateCourierListingIdAndUserId(@Param("userOrderId") Long userOrderId,
			@Param("courierListingId") Long courierListingId,
			@Param("userId") Long userId);

	@Query("SELECT uo.courierListing.pickupDate,uo.courierListing.pickupLocation," +
            "uo.courierListing.pickupTime,uo.courierListing.hawkerListing.name FROM UserOrder uo WHERE uo.id=:id")
	public ArrayList<ArrayList<String>> findCourierPickupDetailsByCourierListingId(@Param("id") Long userOrderId);

	@Query("SELECT uod.id,uod.courierFoodItemDetails.foodItem.name,uod.quantity " +
            "FROM UserOrderDetail uod WHERE uod.userOrder.id=:id")
	public ArrayList<ArrayList<String>> findUserOrderFoodItemByUserOrderId(@Param("id") Long userOrderId);

	@Modifying
	@Transactional
	@Query ("UPDATE UserOrder uo SET uo.userOrderStatus =:status WHERE uo.id=:id")
	public void updateUserOrderStatus(@Param("id") Long userOrderId,@Param("status") String status);

	@Query("select uo.id, uo.courierListing.pickupTime, uo.courierListing.pickupLocation "
			+ " from UserOrder uo")
	public ArrayList<ArrayList<String>> findUserOrder();

	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo")
	public double orderSum();

	@Query("SELECT uo.id,uo.courierListing.id,uo.orderValue,uo.userOrderStatus from UserOrder uo where uo.user.id=:id")
	public ArrayList<ArrayList<String>> findOrderDataByUserId(@Param("id") Long userId);
	
    @Query("SELECT uo.id, uo.courierListing.id, uo.user.name, uo.userOrderStatus FROM UserOrder uo WHERE uo.courierListing.id = :id")
    public List<List<String>> findByCourierListingId(@Param("id") Long id);
    
    
    @Query("SELECT ud.userOrder.id, ud.courierFoodItemDetails.foodItem.name, ud.quantity FROM UserOrderDetail ud WHERE ud.userOrder.id = :id")
    public List<List<String>> findUserDetailsByCourierListingId(@Param("id") Long id);



}
