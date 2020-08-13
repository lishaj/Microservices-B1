package com.cts.brownfield.pss.controller;

import java.util.List;

public class Passenger {


	private long passengerId;
	private String firstName;
	private String lastName;
	private String gender;
	private long mobileNumber;
	private String emailAddress;

	
	private List<CoPassenger> coPassengers;

	
	private BookingRecord bookingRecord;

	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String firstName, String lastName, String gender, long mobileNumber, String emailAddress,
			BookingRecord bookingRecord) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.bookingRecord = bookingRecord;
	}

	public List<CoPassenger> getCoPassengers() {
		return coPassengers;
	}

	
	
	public void setCoPassengers(List<CoPassenger> coPassengers) {
		this.coPassengers = coPassengers;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public BookingRecord getBookingRecord() {
		return bookingRecord;
	}

	public void setBookingRecord(BookingRecord bookingRecord) {
		this.bookingRecord = bookingRecord;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + "Mobile= "+mobileNumber+" email= "+emailAddress +"booking record= "+bookingRecord+"Co Passengers= "+coPassengers+" ]";
	}

}
