package com.example.projectdb.repo;

import com.example.projectdb.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UserOrderRepository extends JpaRepository<UserOrder,Long> {

    @Query("SELECT uo.courierListing.pickupDate,uo.courierListing.pickupLocation,uo.courierListing.pickupTime FROM UserOrder uo")
    public ArrayList<ArrayList<String>> findCourierPickupDetailsByCourierListingId();


}
