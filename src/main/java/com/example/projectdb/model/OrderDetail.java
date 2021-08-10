package com.example.projectdb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantity;
	private Date orderDataTime;
	private Boolean orderReceived;
	private Double orderValue;
	private Double userRating;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private CourierListingDetails courierListingDetails;

	public OrderDetail() {
		super();
	}

	public OrderDetail(Integer quantity, Date orderDataTime, Boolean orderReceived, Double orderValue,
			Double userRating) {
		super();
		this.quantity = quantity;
		this.orderDataTime = orderDataTime;
		this.orderReceived = orderReceived;
		this.orderValue = orderValue;
		this.userRating = userRating;
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

	public Date getOrderDataTime() {
		return orderDataTime;
	}

	public void setOrderDataTime(Date orderDataTime) {
		this.orderDataTime = orderDataTime;
	}

	public Boolean getOrderReceived() {
		return orderReceived;
	}

	public void setOrderReceived(Boolean orderReceived) {
		this.orderReceived = orderReceived;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public Double getUserRating() {
		return userRating;
	}

	public void setUserRating(Double userRating) {
		this.userRating = userRating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CourierListingDetails getCourierListingDetails() {
		return courierListingDetails;
	}

	public void setCourierListingDetails(CourierListingDetails courierListingDetails) {
		this.courierListingDetails = courierListingDetails;
	}
	
	
	

	

}
