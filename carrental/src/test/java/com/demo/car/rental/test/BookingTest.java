package com.demo.car.rental.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.car.rental.exception.CarNotAvailableException;
import com.demo.car.rental.exception.DateFormatNotValidException;
import com.demo.car.rental.exception.DatesNotValidException;
import com.demo.car.rental.rest.IBooking;
import com.demo.car.rental.wrapper.BookingDetails;

public class BookingTest extends CarTest {

	@Autowired
	IBooking booking;

	@Test
	public void canCreateBooking()
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException {

		BookingDetails book = new BookingDetails();

		// booking
		final String BOOKING_BEGINNING = "2023-01-09T05:00";
		final String BOOKING_END = "2023-01-11T07:00";

		long carId = 1l;

		book.setBeginning(BOOKING_BEGINNING);
		book.setEnd(BOOKING_END);
		book.setCarId(carId);

		// create booking
		BookingDetails createBooking = booking.createBooking(book);

		assertEquals("BMW", createBooking.getCar().getModel());
		assertEquals(carId, createBooking.getCar().getId());
		assertEquals(BOOKING_BEGINNING, createBooking.getBeginning().toString());
		assertEquals(BOOKING_END, createBooking.getEnd().toString());
	}
	
	@Test
	public void canCreateBookingWithNoAvailablity()
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException {

		BookingDetails book = new BookingDetails();

		// booking
		final String BOOKING_BEGINNING = "2023-01-09T05:00";
		final String BOOKING_END = "2023-01-11T07:00";

		long carId = 1l;

		book.setBeginning(BOOKING_BEGINNING);
		book.setEnd(BOOKING_END);
		book.setCarId(carId);
		try {
			// create booking
			BookingDetails createBooking = booking.createBooking(book);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Provided dates are not valid!"));
		}
	}
	
	@Test
	public void canCreateBookingWithWrongCarId()
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException {

		BookingDetails book = new BookingDetails();

		// booking
		final String BOOKING_BEGINNING = "2023-01-09T05:00";
		final String BOOKING_END = "2023-01-11T07:00";

		long carId = 8l;

		book.setBeginning(BOOKING_BEGINNING);
		book.setEnd(BOOKING_END);
		book.setCarId(carId);
		try {
			// create booking
			BookingDetails createBooking = booking.createBooking(book);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("No value present"));
		}
	}
	
	@Test
	public void canCreateBookingWithOutAvailabiltyCheck()
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException {

		BookingDetails book = new BookingDetails();

		// booking
		final String BOOKING_BEGINNING = "2023-01-09T05:00";
		final String BOOKING_END = "2023-01-11T07:00";

		long carId = 2l;

		book.setCarId(carId);
		try {
			// create booking
			BookingDetails createBooking = booking.createBooking(book);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Validation failed for object='bookingDetails'. Error count: 2"));
		}
	}
}
