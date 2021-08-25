package com.example.projectdb.repo;

import com.example.projectdb.model.CourierListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CourierPickupDetailRepository extends JpaRepository<CourierListing,Long> {
    @Modifying
    @Transactional
    @Query(value="UPDATE courier_listing SET courier_listing_id =:courierListingId WHERE id=:id", nativeQuery=true)
    public void updateCourierListingId(@Param("courierListingId") Long courierListingId, @Param("id") Long courierDetailId);

}