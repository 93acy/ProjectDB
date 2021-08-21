package com.example.projectdb.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HawkerListing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String address;
	private String postalCode;
	private String stallNo;
	private Long stallImage;
	
	@OneToMany(mappedBy="hawkerListing",cascade=CascadeType.REMOVE)
	private Collection<CourierListing> courierListings;
	
	@OneToMany(mappedBy="hawkerListing",cascade=CascadeType.REMOVE)
	private Collection<FoodItem> foodItems;

	public HawkerListing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HawkerListing(String address, String postalCode, String stallNo, Long stallImage) {
		super();
		this.address = address;
		this.postalCode = postalCode;
		this.stallNo = stallNo;
		this.stallImage = stallImage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStallNo() {
		return stallNo;
	}

	public void setStallNo(String stallNo) {
		this.stallNo = stallNo;
	}

	public Long getStallImage() {
		return stallImage;
	}

	public void setStallImage(Long stallImage) {
		this.stallImage = stallImage;
	}

	public Collection<CourierListing> getCourierListings() {
		return courierListings;
	}

	public void setCourierListings(Collection<CourierListing> courierListings) {
		this.courierListings = courierListings;
	}

	public Collection<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(Collection<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

    
	
	

	

}
