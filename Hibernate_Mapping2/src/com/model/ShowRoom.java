package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "showroom")
public class ShowRoom implements Serializable{
	@Id
	@Column(name = "showroom_id")
	@GenericGenerator(name = "ref",strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int showroom_id;
	@Column(name="location")
	private String location;
	@Column(name = "manager")
	private String manager;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "showroom_car",
			joinColumns = {@JoinColumn(name="showroom_id")},
			inverseJoinColumns = {@JoinColumn(name = "carid")})
	private Collection<Car> shcar = new ArrayList<Car>();

	public ShowRoom() {
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Car> getShcar() {
		return shcar;
	}

	public void setShcar(Collection<Car> shcar) {
		this.shcar = shcar;
	}

	public int getShowroom_id() {
		return showroom_id;
	}

	public void setShowroom_id(int showroom_id) {
		this.showroom_id = showroom_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	

}
