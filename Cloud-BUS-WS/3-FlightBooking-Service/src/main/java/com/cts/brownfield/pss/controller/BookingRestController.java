package com.cts.brownfield.pss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.CoPassenger;
import com.cts.brownfield.pss.entity.Passenger;
import com.cts.brownfield.pss.service.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/api/pss")
@RefreshScope
public class BookingRestController {
	@Autowired
	private BookingService bookingService;

	@Value("${coupon.code}")
	private String couponCode;

	@PostMapping("/book/{id}/{numberofPassengers}")
	public Passenger bookFlight(@RequestBody Passenger passenger, @PathVariable("id") long id,
			@PathVariable("numberofPassengers") int numberofPassengers) {
		System.out.println(">>>>>  Coupon Code :::::: " + couponCode);
		Passenger bookedPassenger = bookingService.bookFlight(passenger, id, numberofPassengers);
		List<CoPassenger> coPassengers = passenger.getCoPassengers();

		if (coPassengers != null && passenger.getCoPassengers().size() == numberofPassengers - 1) {
			return bookedPassenger;
		}

		return null;
	}

	@GetMapping("/book/{bookingId}")
	public BookingRecord getBookingInfo(@PathVariable("bookingId") long bookingId) {
		System.out.println(">>>>> USER NAME:::::: " + couponCode);

		return bookingService.getBookingInfo(bookingId);
	}

}
