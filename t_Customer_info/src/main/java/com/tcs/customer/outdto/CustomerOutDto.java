package com.tcs.customer.outdto;

public class CustomerOutDto {

	private Integer id;

	private String name;

	private String city;

	private String state;

	private String country;
	
	private Integer pin;

	private String date_registration;

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

	public String getDate_registration() {
		return date_registration;
	}

	public void setDate_registration(String date_registration) {
		this.date_registration = date_registration;
	}

}
