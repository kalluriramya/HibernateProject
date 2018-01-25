package com.training.java;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class ContactPOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	
	@Column(name = "CONTACT_ID")
	private int contactId;

	@Column(name = "FIRST_NAME") 
	private String firstName;
	
	@Column(name = "LAST_NAME") 
	private String lastName;
	
	@Column(name = "DOB")
	private Date dob;

	@Column(name = "EMAIL") 
	private String email; 

	@Column(name = "MOBILE") 
	private String mobile;
	
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ContactPOJO [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
