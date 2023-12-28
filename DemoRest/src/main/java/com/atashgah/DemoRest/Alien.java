package com.atashgah.DemoRest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="aliens")
public class Alien 
{
	@Id
	private String aname;
	private int points;
	private int id;
	@Override
	public String toString() {
		return "Alien [aname=" + aname + ", points=" + points + ", id=" + id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}
