package com.example.projectdb.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    @Query("select uo.id, uo.courierListing.pickupTime, uo.courierListing.pickupLocation "
            + " from UserOrder uo")
    public ArrayList<ArrayList<String>> findUserOrder();
	
    @Query("SELECT SUM(uo.orderValue) FROM UserOrder uo")
    public double orderSum();

	
	
}
