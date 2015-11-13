package mum.cs544.domain;

import javax.persistence.Entity;

@Entity
public class Administrator extends Person {
	
	private String position;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	} 
}
