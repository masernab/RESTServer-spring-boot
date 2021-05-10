package com.example.demo.model;


import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	
	@Id
	private String id;
	private String name;
	private String lastName;
	private int age;
	private String cedula;
	private String phone;
	
	public Person(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("lastName") String lastName, @JsonProperty("age") int age, @JsonProperty("cedula") String cedula, @JsonProperty("phone") String phone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.lastName = lastName;
		this.cedula = cedula;
		this.phone= phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
