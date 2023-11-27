package com.safetynet.alerts.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	
	
public Person (String firstName,String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	
}

public Person (String firstName, String lastName, String address, String phone)
{
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phone = phone;
}


public Person (String firstName, String lastName, String address, String email, String phone)
{
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.email = email;
	this.phone = phone;
}

public Person() {
	
}



public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(firstName, person.firstName) &&
            Objects.equals(lastName, person.lastName);
}

@Override
public int hashCode() {
    return Objects.hash(firstName, lastName);
}

@Override
public String toString() {
    return "Person{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", zip='" + zip + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
}
}
