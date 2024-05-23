package com.example.demoRegCrud.entities;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Hobbies> hobbies;

	@Temporal(TemporalType.DATE)
	private Date date;
	private String designation;
	private String address;
	
	@Lob
	private Blob image;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public List<Hobbies> getHobbies() {
		return hobbies;
	}
	public Date getDate() {
		return date;
	}
	public String getDesignation() {
		return designation;
	}
	public String getAddress() {
		return address;
	}
	public Blob getImage() {
		return image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setHobbies(List<Hobbies> hobbies) {
		this.hobbies = hobbies;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
			
}
