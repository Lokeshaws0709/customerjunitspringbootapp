package com.tcs.customer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "pin")
	private Integer pin;

	@Column(name = "date_registration")
	private Date date_registration;

	@Column(name = "price")
	private Integer price;

	@Column(name = "countitems")
	private Integer countItems;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
	

	public Integer getCountItems() {
		return countItems;
	}

	public void setCountItems(Integer countItems) {
		this.countItems = countItems;
	}

	public Integer getId() {
		return id;

	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Date getDate_registration() {
		return date_registration;
	}

	public void setDate_registration(Date date_registration) {
		this.date_registration = date_registration;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pin=" + pin + ", date_registration=" + date_registration + ", price=" + price + ", countitems="
				 + "]";
	}

}
