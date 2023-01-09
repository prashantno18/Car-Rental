package com.demo.car.rental.service;

import javax.validation.Valid;

import com.demo.car.rental.exception.CarNotAvailableException;
import com.demo.car.rental.exception.DateFormatNotValidException;
import com.demo.car.rental.exception.DatesNotValidException;
import com.demo.car.rental.wrapper.BookingDetails;

public interface IBookingService {

	BookingDetails createBooking(@Valid BookingDetails bookingDetails)
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException;

}
