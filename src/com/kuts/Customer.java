package com.kuts;

public class Customer {
	
	/**
	 * @author Sidhu
	 * Customer Model Bean
	 */
	private int ID;
	private String firstName;
	private String lastName;
	private String street;
	private String city;

	public Customer() {
		System.out.println("Initializing Customer Bean");
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName.trim();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName.trim();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city.trim();
	}

}
