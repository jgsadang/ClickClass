package mum.cs544.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    
	@Id
	@GeneratedValue
	private int id;
	
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	
}
