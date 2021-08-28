package com.example.projectdb.repo;

import com.example.projectdb.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface UserOrderRepository extends JpaRepository<UserOrder,Long> {

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

}
