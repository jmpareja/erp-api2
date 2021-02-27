package com.jmpsolutions.erpapi2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	@JsonIgnore
	private @Id @GeneratedValue Long id;
	private String name;
	private String joindate;
	private String age;
	private String company;
	private String email;
	private String phone;
	private String salary;
	
	@OneToOne(optional = true)
	private Address address;
	
	public Employee() {}
	
	public Employee(String name, String joindate, String age, String company, String email, String phone,
			String salary, Address address) {
		super();
		this.name = name;
		this.joindate = joindate;
		this.age = age;
		this.company = company;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.address = address;
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
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
		
}
