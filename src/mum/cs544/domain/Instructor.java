package mum.cs544.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Instructor extends Person implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    
	
	@OneToMany(mappedBy="instructor")
	private List<Course> courses ;
	
	@Column(length=512)
	private String resume;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
}
