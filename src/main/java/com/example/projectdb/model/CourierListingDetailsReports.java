package com.example.projectdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourierListingDetailsReports {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String reportDescription;
	
	@ManyToOne
	private CourierFoodItemDetails courierFoodItemDetails;

	public CourierListingDetailsReports() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public CourierFoodItemDetails getCourierFoodItemDetails() {
		return courierFoodItemDetails;
	}

	public void setCourierFoodItemDetails(CourierFoodItemDetails courierFoodItemDetails) {
		this.courierFoodItemDetails = courierFoodItemDetails;
	}

	
	
	

}
