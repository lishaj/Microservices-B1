package com.cts.brownfield.pss.controller;

import java.util.Date;
import java.util.Set;

 

 
public class BookingRecord {

 	private long bookingId;
    private String flightNumber;
    private String origin;
    private String destination;
    private String flightDate;
    private Date bookingDate;
    private String fare;
    private String status;
    

	public BookingRecord() {
	}    
    
	public BookingRecord(String flightNumber,String from, String to, 
						String flightDate, Date bookingDate, String fare) {
		this.flightNumber = flightNumber;
		this.origin = from;
		this.destination = to;
		this.flightDate = flightDate;
		this.bookingDate = bookingDate;
		this.fare = fare;
 	}
	
	

	
	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	

	@Override
	public String toString() {
		return "BookingRecord [id=" + bookingId + ", flightNumber=" + flightNumber + ", from=" + origin + ", to=" + destination
				+ ", flightDate=" + flightDate + ", bookingDate=" + bookingDate+ "]";
	}
    
    
    
}
