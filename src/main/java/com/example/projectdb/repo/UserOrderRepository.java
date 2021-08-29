package com.example.projectdb.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    @Query("select uo.id, uo.courierListing.pickupTime, uo.courierListing.pickupLocation "
            + " from UserOrder uo")
    public ArrayList<ArrayList<String>> findUserOrder();
	
    @Query("SELECT uo.id, uo.courierListing.id, uo.user.name, uo.userOrderStatus FROM UserOrder uo WHERE uo.courierListing.id = :id")
    public List<List<String>> findByCourierListingId(@Param("id") Long id);
    
    //@Query("SELECT uo.id FROM UserOrder uo WHERE uo.CourierListing.id = :id")
    //public List<List<String>> findIdByCourierListingId(@Param("id") Long id);
    
    @Query("SELECT ud.userOrder.id, ud.courierFoodItemDetails.foodItem.name, ud.quantity FROM UserOrderDetail ud WHERE ud.userOrder.id = :id")
    public List<List<String>> findUserDetailsByCourierListingId(@Param("id") Long id);
	
}
