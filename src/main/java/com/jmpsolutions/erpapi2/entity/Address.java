package com.jmpsolutions.erpapi2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class for Address information.
 * 
 * @author jmpareja
 *
 */
@Entity
public class Address {
	
	/**
	 * The field 'id' is set to be ignored in JSON.
	 */
	@JsonIgnore
	private @Id @GeneratedValue Long id;
	
	private String street;
	
	private String city;
	
	private String zipcode;
	
	/**
	 * Default constructor.
	 */
	public Address() {}
	
	/**
	 * Constructor with field parameter values.
	 * @param street value for street
	 * @param city	value for city
	 * @param zipcode value for zip code
	 */
	public Address(String street, String city, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}
	
	/**
	 * Gets the value of field 'id'.
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the value of field 'id'.
	 * @param id value of field 'id' to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the value of field 'street'.
	 * @return value of field 'street'.
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the value of field 'street'.
	 * @param street value to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Gets the value of field 'city'.
	 * @return String object value of field 'city'.
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the value of field 'city'.
	 * @param city value to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the value of field 'zipcode'.
	 * @return String object for field 'zipcode'.
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * Sets the value of field 'zipcode'.
	 * @param zipcode The value to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
