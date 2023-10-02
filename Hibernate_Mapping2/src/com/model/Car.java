package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "car")
public class Car implements Serializable{
	@Id
	@Column(name = "carid")
	@GenericGenerator(name = "ref",strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int carid;
	@Column(name="carname")
	private String carname;
	@Column(name="color")
	private String color;
	@ManyToMany(mappedBy = "shcar", cascade = CascadeType.ALL)
	private Collection<ShowRoom> sr = new ArrayList<ShowRoom>();
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Collection<ShowRoom> getsr() {
		return sr;
	}


	public void setCar(Collection<ShowRoom> sr) {
		this.sr = sr;
	}


	public int getCarid() {
		return carid;
	}


	public void setCarid(int carid) {
		this.carid = carid;
	}


	public String getCarname() {
		return carname;
	}


	public void setCarname(String carname) {
		this.carname = carname;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

}
