package com.example.projectdb.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CourierListingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Double pricePerUnit;
	private Integer totalQuantity;
	private Long reportCount;
	
	@OneToMany(mappedBy="courierListingDetails",cascade=CascadeType.REMOVE)
	private Collection<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy="courierListingDetails",cascade=CascadeType.REMOVE)
	private Collection<FoodItem> foodItems;
	
	@OneToMany(mappedBy="courierListingDetails",cascade=CascadeType.REMOVE)
	private Collection<CourierListingDetailsReports> reports;
	
	@ManyToOne
	private CourierListing courierListing;

	
	public CourierListingDetails() {
		super();
	}

	public CourierListingDetails(Double pricePerUnit, Integer totalQuantity, Long reportCount) {
		super();
		this.pricePerUnit = pricePerUnit;
		this.totalQuantity = totalQuantity;
		this.reportCount = reportCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Long getReportCount() {
		return reportCount;
	}

	public void setReportCount(Long reportCount) {
		this.reportCount = reportCount;
	}

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Collection<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(Collection<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public Collection<CourierListingDetailsReports> getReports() {
		return reports;
	}

	public void setReports(Collection<CourierListingDetailsReports> reports) {
		this.reports = reports;
	}

	public CourierListing getCourierListing() {
		return courierListing;
	}

	public void setCourierListing(CourierListing courierListing) {
		this.courierListing = courierListing;
	}
	
	
	
	

}
