package com.addict.arts.webproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table()
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column
    private String name;
	@Column
    private int age;
	@Column
    private List<String> previousVisits;
	@Column
    private Gender gender;
	@Column
    private long phNumber;
	@Column
    private String emailId;
	@Column
	private String bookedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getPreviousVisits() {
		return previousVisits;
	}

	public void setPreviousVisits(List<String> previousVisits) {
		this.previousVisits = previousVisits;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public long getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}
}