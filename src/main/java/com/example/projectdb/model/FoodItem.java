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
public class FoodItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private String category;
	private Double upperPrice;
	private Double lowerPrice;
	
	@OneToMany(mappedBy="foodItem",cascade=CascadeType.REMOVE)
	private Collection<CourierFoodItemDetails> courierFoodItemDetails;
	
	@ManyToOne//(cascade = {CascadeType.ALL})
	private HawkerListing hawkerListing;

	public FoodItem() {
		super();
	}

	public FoodItem(String name, String description, String category, Double upperPrice, Double lowerPrice) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.upperPrice = upperPrice;
		this.lowerPrice = lowerPrice;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getUpperPrice() {
		return upperPrice;
	}

	public void setUpperPrice(Double upperPrice) {
		this.upperPrice = upperPrice;
	}

	public Double getLowerPrice() {
		return lowerPrice;
	}

	public void setLowerPrice(Double lowerPrice) {
		this.lowerPrice = lowerPrice;
	}


	public Collection<CourierFoodItemDetails> getCourierFoodItemDetails() {
		return courierFoodItemDetails;
	}

	public void setCourierFoodItemDetails(Collection<CourierFoodItemDetails> courierFoodItemDetails) {
		this.courierFoodItemDetails = courierFoodItemDetails;
	}

	public HawkerListing getHawkerListing() {
		return hawkerListing;
	}

	public void setHawkerListing(HawkerListing hawkerListing) {
		this.hawkerListing = hawkerListing;
	}
	
	
	
	
	

}
