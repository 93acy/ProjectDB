package com.example.projectdb.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Double orderValue;
	private String userOrderStatus;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="userOrder",cascade=CascadeType.REMOVE)
	private Collection<UserOrderDetail> userOrderDetails;
	
	@ManyToOne
	private CourierListing courierListing;

	public UserOrder() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public String getUserOrderStatus() {
		return userOrderStatus;
	}

	public void setUserOrderStatus(String userOrderStatus) {
		this.userOrderStatus = userOrderStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<UserOrderDetail> getUserOrderDetails() {
		return userOrderDetails;
	}

	public void setUserOrderDetails(Collection<UserOrderDetail> userOrderDetails) {
		this.userOrderDetails = userOrderDetails;
	}

	public CourierListing getCourierListing() {
		return courierListing;
	}

	public void setCourierListing(CourierListing courierListing) {
		this.courierListing = courierListing;
	}

	

	

}
