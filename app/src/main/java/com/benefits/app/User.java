package com.benefits.app;

import java.util.ArrayList;
import java.util.Collection;


import org.codehaus.jackson.annotate.JsonIgnore;

public abstract class User extends DomainEntity {
	private String name;
	private String surname;
	private String email;
	private String nationality;
	private String city;

	// RelationShip
	private Collection<Comment> comments;

	public User() {
		super();
		comments = new ArrayList<Comment>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonIgnore
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> myComments) {
		this.comments = myComments;
	}

}
