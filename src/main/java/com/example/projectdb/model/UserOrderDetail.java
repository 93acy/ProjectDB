package com.example.projectdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantity;
	
	@ManyToOne
	private UserOrder userOrder;
	
	@OneToOne
	private CourierFoodItemDetails courierFoodItemDetails;

	public UserOrderDetail() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	public CourierFoodItemDetails getCourierFoodItemDetails() {
		return courierFoodItemDetails;
	}

	public void setCourierFoodItemDetails(CourierFoodItemDetails courierFoodItemDetails) {
		this.courierFoodItemDetails = courierFoodItemDetails;
	}
	
	
	
	

}
