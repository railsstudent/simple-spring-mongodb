package com.blueskyconnie.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.blueskyconnie.converter.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@Document(collection="people")
public class Person {

	public enum Gender { MALE, FEMALE };
	
	// http://stackoverflow.com/questions/25512381/rename-objectid-id-to-id-in-jackson-deserialization-with-jongo-and-mongodb
	@Id
	@JsonSerialize(using = ObjectIdSerializer.class)
	private ObjectId id;
	
	@Field("firstname")
	private String firstname;

	@Field("lastname")
	private String lastname;
	
	@Field("gender")
	private Gender gender;
	
	public Person() {
		
	}
	
	@PersistenceConstructor
	public Person(ObjectId id, String firstname, String lastname, Gender gender) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
	}

	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	  
	  
	  
}
