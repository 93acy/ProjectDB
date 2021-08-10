package com.example.projectdb.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String nric;
	private String name;
	private String race;
	private String dob;
	private String nationality;
	private String gender;
	private String address;
	private String mobileNo;
	private String vicinity;
	private Double customerRating;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private Collection<OrderDetail> orderDetails;

	public User() {
		super();
	}

	public User(String username, String password, String nric, String name, String race, String dob, String nationality,
			String gender, String address, String mobileNo, String vicinity, Double customerRating) {
		super();
		this.username = username;
		this.password = password;
		this.nric = nric;
		this.name = name;
		this.race = race;
		this.dob = dob;
		this.nationality = nationality;
		this.gender = gender;
		this.address = address;
		this.mobileNo = mobileNo;
		this.vicinity = vicinity;
		this.customerRating = customerRating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public Double getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(Double customerRating) {
		this.customerRating = customerRating;
	}

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	

}
