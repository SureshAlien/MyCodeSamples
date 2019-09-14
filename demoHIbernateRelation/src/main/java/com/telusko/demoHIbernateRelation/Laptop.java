package com.telusko.demoHIbernateRelation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop 
{
	private String lname;
	@Id
	private int lid;
	
	/*@ManyToOne
	private Student student; */

	@ManyToMany
	private List<Student> student = new ArrayList<Student>();
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [lname=" + lname + ", lid=" + lid + "]";
	}
	
}
