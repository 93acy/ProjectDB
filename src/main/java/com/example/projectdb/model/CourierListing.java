package com.example.projectdb.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CourierListing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String pickupLocation;
	private String pickupDate;
	private String pickupTime;
	private String orderBeforeTime;	
	private String courierOrderStatus;
	
	
	@ManyToOne
	private Courier courier;
	
	@ManyToOne
	private HawkerListing hawkerListing;
	
	@OneToMany(mappedBy="courierListing",cascade=CascadeType.REMOVE)
	private Collection<CourierFoodItemDetails> courierListingDetails;

	@OneToMany(mappedBy="courierListing",cascade=CascadeType.REMOVE)
	private Collection<UserOrder> userOrders;
	
	public CourierListing() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getOrderBeforeTime() {
		return orderBeforeTime;
	}

	public void setOrderBeforeTime(String orderBeforeTime) {
		this.orderBeforeTime = orderBeforeTime;
	}

	public String getCourierOrderStatus() {
		return courierOrderStatus;
	}

	public void setCourierOrderStatus(String courierOrderStatus) {
		this.courierOrderStatus = courierOrderStatus;
	}

	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}

	public HawkerListing getHawkerListing() {
		return hawkerListing;
	}

	public void setHawkerListing(HawkerListing hawkerListing) {
		this.hawkerListing = hawkerListing;
	}

	public Collection<CourierFoodItemDetails> getCourierListingDetails() {
		return courierListingDetails;
	}

	public void setCourierListingDetails(Collection<CourierFoodItemDetails> courierListingDetails) {
		this.courierListingDetails = courierListingDetails;
	}



	public Collection<UserOrder> getUserOrders() {
		return userOrders;
	}



	public void setUserOrders(Collection<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}
	
	
	
	

}
