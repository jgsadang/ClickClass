package mum.cs544.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Administrator extends Person implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
	
	private String position;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	} 
}
