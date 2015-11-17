package mum.cs544.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address  implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    
    
	@NotEmpty(message = "Can not be left blank")
	private String street;
	@Pattern(regexp = "^\\d{5}(-\\d{4})?$", message = "should be nnnnn-nnnn format")
	private String zipcode;
	@NotEmpty(message = "Can not be left blank")
	private String city;
	@NotEmpty(message = "Can not be left blank")
	private String country;
	@NotEmpty(message = "Can not be left blank")
	private String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
