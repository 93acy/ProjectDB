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
public class CourierListing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String pickupLocation;
	private Double totalPrice;
	private Boolean optionForDoorDelivery;
	private String vicinity;
	private Double courierRating;
	
	@ManyToOne
	private Courier courier;
	
	@ManyToOne
	private HawkerListing hawkerListing;
	
	@OneToMany(mappedBy="courierListing",cascade=CascadeType.REMOVE)
	private Collection<CourierListingDetails> courierListingDetails;

	public CourierListing() {
		super();
	}

	public CourierListing(String pickupLocation, Double totalPrice, Boolean optionForDoorDelivery, String vicinity,
			Double courierRating) {
		super();
		this.pickupLocation = pickupLocation;
		this.totalPrice = totalPrice;
		this.optionForDoorDelivery = optionForDoorDelivery;
		this.vicinity = vicinity;
		this.courierRating = courierRating;
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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getOptionForDoorDelivery() {
		return optionForDoorDelivery;
	}

	public void setOptionForDoorDelivery(Boolean optionForDoorDelivery) {
		this.optionForDoorDelivery = optionForDoorDelivery;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public Double getCourierRating() {
		return courierRating;
	}

	public void setCourierRating(Double courierRating) {
		this.courierRating = courierRating;
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

	public Collection<CourierListingDetails> getCourierListingDetails() {
		return courierListingDetails;
	}

	public void setCourierListingDetails(Collection<CourierListingDetails> courierListingDetails) {
		this.courierListingDetails = courierListingDetails;
	}
	
	

}
