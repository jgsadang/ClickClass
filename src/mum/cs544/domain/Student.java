package mum.cs544.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
	
	@OneToMany(mappedBy="student" )
	private List<Attendance> attendances;
	
	@OneToOne
	private CreditCard creditCard;
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}
	
	public void addAttendance(Attendance at){
		attendances.add(at);
	}
}
