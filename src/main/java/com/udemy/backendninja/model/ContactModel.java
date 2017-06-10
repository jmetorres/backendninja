package com.udemy.backendninja.model;

public class ContactModel {
	
	private int id;
	private String firstname;
	private String lastname;
	private String telephone;
	private String city;
	
	public ContactModel(){}
	
	public ContactModel(int id, String firstName, String lastName, String telephone, String city) {
		super();
		this.id = id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.telephone = telephone;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone="
				+ telephone + ", city=" + city + "]";
	}
	
	
	
}
