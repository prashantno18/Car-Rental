package com.demo.car.rental.rest;

import javax.validation.Valid;

import com.demo.car.rental.exception.CarNotAvailableException;
import com.demo.car.rental.exception.DateFormatNotValidException;
import com.demo.car.rental.exception.DatesNotValidException;
import com.demo.car.rental.wrapper.BookingDetails;

public interface IBooking {

	BookingDetails createBooking(@Valid BookingDetails BookingDetails)
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException;

}
