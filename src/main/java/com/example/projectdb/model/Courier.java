package com.example.projectdb.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Proxy(lazy=false)
public class Courier{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String vehicle;
	private String bankAccNo;
	
	@OneToMany(mappedBy="courier",cascade=CascadeType.REMOVE)
	private Collection<CourierListing> courierListings;

	public Courier() {
		super();
	}

	public Courier(String vehicle, String bankAccNo) {
		super();
		this.vehicle = vehicle;
		this.bankAccNo = bankAccNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public Collection<CourierListing> getCourierListings() {
		return courierListings;
	}

	public void setCourierListings(Collection<CourierListing> courierListings) {
		this.courierListings = courierListings;
	}

    
	
	
	
	

}
