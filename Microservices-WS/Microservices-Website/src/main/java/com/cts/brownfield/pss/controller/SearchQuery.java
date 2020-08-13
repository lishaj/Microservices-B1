package com.cts.brownfield.pss.controller;

import java.time.LocalDate;

public class SearchQuery {
	private String origin;
	private String destination;
	private LocalDate flightDate;
	private int numberofPassengers;
	
	
	public SearchQuery() {
		super();
	}


	@Override
	public String toString() {
		return "SearchQuery [origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate + "]";
	}


	public SearchQuery(String origin, String destination, LocalDate flightDate,int numberofPassengers) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.numberofPassengers=numberofPassengers;
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
	public LocalDate getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}


	public int getNumberofPassengers() {
		return numberofPassengers;
	}


	public void setNumberofPassengers(int numberofPassengers) {
		this.numberofPassengers = numberofPassengers;
	}
	
	
	
	
}