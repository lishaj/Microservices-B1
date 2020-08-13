package com.cts.brownfield.pss.controller;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {

	private long id;

	private String flightNumber;
	private String origin;
	private String destination;
	private LocalDate flightDate;
	private LocalTime flightTime;
	private String duration;

	private Fares fares;
	private double fare;

	public Flight() {
		super();
	}

	public Flight(String flightNumber, String origin, String destination,  LocalDate flightDate,
			LocalTime flightTime, String duration,Fares fares) {
		
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.fares = fares;

	}
	public Flight(long id,String flightNumber, String origin, String destination,  LocalDate flightDate,
			LocalTime flightTime, String duration,double fare) {
		this.id=id;
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.fare = fare;

	}


	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public Fares getFares() {
		return fares;
	}

	public void setFares(Fares fares) {
		this.fares = fares;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNUmber=" + flightNumber + ", origin=" + origin + ", destination="
				+ destination + ", flightDate=" + flightDate + ", fares=" + fares + "]";
	}

}
