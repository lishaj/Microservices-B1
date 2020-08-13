package com.cts.brownfield.pss.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;



@Controller
public class WebsiteController {

	RestTemplate searchClient = new RestTemplate();

	RestTemplate bookingClient = new RestTemplate();

	RestTemplate checkInClient = new RestTemplate();
	private static final String searchURL="http://localhost:8082/api/pss";
	private static final String bookURL="http://localhost:8083/api/pss";



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		SearchQuery query = new SearchQuery("DELHI", "CHENNAI", LocalDate.of(2020, 8, 21), 2);
		UIData uiData = new UIData();
		uiData.setSearchQuery(query);
		model.addAttribute("uidata", uiData);
		return "SearchFlight";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute UIData uiData, Model model) {
		Flight[] flights = searchClient.postForObject(searchURL+"/findFlights",uiData.getSearchQuery(), Flight[].class);
		uiData.setFlights(Arrays.asList(flights));
		model.addAttribute("uidata", uiData);
		return "result";
	}

	@RequestMapping("/book/{id}/{flightNumber}/{origin}/{destination}/{flightDate}/{flightTime}/{duration}/{fare}/{numberofPassengers}")
	public String book(@PathVariable long id,@PathVariable String flightNumber, @PathVariable String origin, @PathVariable String destination,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime flightTime,
			@PathVariable String duration,@PathVariable double fare, @RequestParam int numberofPassengers,
			Model model) {

		UIData uiData = new UIData();
		Flight flight = new Flight(id,flightNumber, origin, destination, flightDate, flightTime, duration,fare);
   		uiData.setSelectedFlight(flight);
   		uiData.setPassenger(new Passenger());
	    model.addAttribute("uidata",uiData);
	    model.addAttribute("numberofPassengers",numberofPassengers);

		return "BookFlight";
	}
	
	@RequestMapping("/bookFlight")
	public String bookFlight(@ModelAttribute UIData uiData,Model data,@RequestParam("id")long id,@RequestParam("numberofPassengers")int numberofPassengers) {
		
		Passenger p=uiData.getPassenger();
		
		Flight flight = searchClient.getForObject(searchURL + "/findFlight/" + id, Flight.class);
		
		data.addAttribute("flight", flight);
		data.addAttribute("numberofPassengers",numberofPassengers);
		Passenger passenger=bookingClient.postForObject(bookURL+"/book/"+flight.getId()+"/"+numberofPassengers, p, Passenger.class);
		data.addAttribute("passenger", passenger);

		
		return "BookingConfirmation";
	}

}
