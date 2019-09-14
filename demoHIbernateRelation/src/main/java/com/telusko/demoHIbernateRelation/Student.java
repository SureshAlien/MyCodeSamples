package com.telusko.demoHIbernateRelation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="Student")
public class Student 
{
	@Id
	private int rollno;
	private String sname;
	private int marks;
	
	/*one to one relation
	@OneToOne
	private Laptop laptop; */
	
	/*@OneToMany(mappedBy="student")
	private List<Laptop> laptop = new ArrayList<Laptop>();*/
	
	@ManyToMany(mappedBy="student")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", marks=" + marks + "]";
	}
	

}
