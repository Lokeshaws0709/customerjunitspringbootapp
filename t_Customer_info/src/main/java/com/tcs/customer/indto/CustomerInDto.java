package com.tcs.customer.indto;

import java.util.Date;

public class CustomerInDto {

	private Integer id;

	private String name;

	private String city;

	private String state;

	private String country;

	private Integer pin;

	private Date date_registration;
	
	private Integer price;
	
	private Integer countitems;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCountitems() {
		return countitems;
	}

	public void setCountitems(Integer countitems) {
		this.countitems = countitems;
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
		return "CustomerInDto [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", country="
				+ country + ", pin=" + pin + ", date_registration=" + date_registration + ", price=" + price
				+ ", countitems=" + countitems + "]";
	}

}
