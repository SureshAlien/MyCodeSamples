package com.telusko.demoJPA;

public class AlienJpa 
{
	private String aname;
	private int aid;
	private String tech;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "AlienJpa [aname=" + aname + ", aid=" + aid + ", tech=" + tech + "]";
	}
	
	

}
