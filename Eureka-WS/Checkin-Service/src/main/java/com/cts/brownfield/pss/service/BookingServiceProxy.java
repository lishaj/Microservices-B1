package com.cts.brownfield.pss.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.brownfield.pss.entity.BookingRecord;

@FeignClient(name="booking-service",url = "http://localhost:8083/api/pss")
public interface BookingServiceProxy {
	
	@GetMapping("/book/{bookingId}")
	BookingRecord book(@PathVariable("bookingId") long bookingId);

}
