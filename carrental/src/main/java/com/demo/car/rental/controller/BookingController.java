package com.demo.car.rental.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.car.rental.exception.CarNotAvailableException;
import com.demo.car.rental.exception.DateFormatNotValidException;
import com.demo.car.rental.exception.DatesNotValidException;
import com.demo.car.rental.rest.IBooking;
import com.demo.car.rental.service.IBookingService;
import com.demo.car.rental.wrapper.BookingDetails;

@RestController
@RequestMapping("booking")
public class BookingController implements IBooking {

	private Logger log = LogManager.getLogger(BookingController.class);

	@Autowired
	IBookingService bookingService;

	@PostMapping("/book")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public BookingDetails createBooking(@Valid @RequestBody BookingDetails BookingDetails)
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException {

		log.debug("createBooking with bookingDetails :{}", BookingDetails);

		return bookingService.createBooking(BookingDetails);
	}
}
