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

	@Query("SELECT ROUND(SUM(uo.orderValue), 2) FROM UserOrder uo")
	public Double orderSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%01/2021'")
	public Double janSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%02/2021'")
	public Double febSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%03/2021'")
	public Double marSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%04/2021'")
	public Double aprSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%05/2021'")
	public Double maySum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%06/2021'")
	public Double junSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%07/2021'")
	public Double julSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%08/2021'")
	public Double augSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%09/2021'")
	public Double sepSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%10/2021'")
	public Double octSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%11/2021'")
	public Double novSum();
	
	@Query("SELECT SUM(uo.orderValue) FROM UserOrder uo WHERE uo.courierListing.pickupDate LIKE '%12/2021'")
	public Double decSum();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%01/2021' ")
	public long janOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%02/2021' ")
	public long febOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%03/2021' ")
	public long marOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%04/2021' ")
	public long aprOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%05/2021' ")
	public long mayOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%06/2021' ")
	public long junOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%07/2021' ")
	public long julOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%08/2021' ")
	public long augOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%09/2021' ")
	public long sepOrder();

	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%10/2021' ")
	public long octOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%11/2021' ")
	public long novOrder();
	
	@Query("Select COUNT(*) FROM UserOrder uo WHERE uo.courierListing.pickupDate Like '%12/2021' ")
	public long decOrder();
	
	

	@Query("SELECT uo.id,uo.courierListing.id,uo.orderValue,uo.userOrderStatus from UserOrder uo where uo.user.id=:id")
	public ArrayList<ArrayList<String>> findOrderDataByUserId(@Param("id") Long userId);
	
    @Query("SELECT uo.id, uo.courierListing.id, uo.user.name, uo.userOrderStatus FROM UserOrder uo WHERE uo.courierListing.id = :id")
    public List<List<String>> findByCourierListingId(@Param("id") Long id);
    
    
    @Query("SELECT ud.userOrder.id, ud.courierFoodItemDetails.foodItem.name, ud.quantity FROM UserOrderDetail ud WHERE ud.userOrder.id = :id")
    public List<List<String>> findUserDetailsByCourierListingId(@Param("id") Long id);



}
