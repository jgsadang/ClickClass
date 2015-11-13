package mum.cs544.domain;

import java.util.List;

public class Person {
	
private String firstName;
private String lastName;
private String email;
private CreditCard creditCard;
private Address address;
private List<Course> courses;

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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public CreditCard getCreditCard() {
	return creditCard;
}
public void setCreditCard(CreditCard creditCard) {
	this.creditCard = creditCard;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<Course> getCourses() {
	return courses;
}
public void setCourses(List<Course> courses) {
	this.courses = courses;
}



}
