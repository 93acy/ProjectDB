package com.example.projectdb.repo;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
	
	@Modifying
	@Transactional
	@Query(value="UPDATE food_item SET hawker_listing_id =:id WHERE name=:name", nativeQuery=true)
	public void updateHawkerId(@Param("name") String name,@Param("id") Long hawkerId);
	
	@Query(value="select * from food_item where id=:id", nativeQuery=true)
	public FoodItem findFoodItemById(@Param("id") Long foodId);
	


}
