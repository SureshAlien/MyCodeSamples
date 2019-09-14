package com.telusko.demoHQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="StudentHql")
public class Student {

	@Id
	private int rollno;
	private String sname;
	private int marks;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String snmae) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", marks=" + marks + "]";
	}
	
}
