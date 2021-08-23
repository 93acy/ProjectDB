package com.example.projectdb.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectdb.model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO food_item (name) VALUES (:name)", nativeQuery=true)
	public void saveFood(@Param("name") String name);

}
