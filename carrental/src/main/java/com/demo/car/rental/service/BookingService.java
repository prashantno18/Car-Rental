package com.demo.car.rental.service;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.car.rental.dao.IBookingDao;
import com.demo.car.rental.dao.ICarDao;
import com.demo.car.rental.entity.Booking;
import com.demo.car.rental.entity.Car;
import com.demo.car.rental.exception.CarNotAvailableException;
import com.demo.car.rental.exception.DateFormatNotValidException;
import com.demo.car.rental.exception.DatesNotValidException;
import com.demo.car.rental.repository.ICarRepository;
import com.demo.car.rental.utility.Utility;
import com.demo.car.rental.wrapper.BookingDetails;

@Service
public class BookingService implements IBookingService {

	private Logger log = LogManager.getLogger(BookingService.class);
	
	@Autowired
	ICarRepository carRepo;
	
	@Autowired
	ICarDao carDao;
	
	@Autowired
	IBookingDao bookingDao;
	

	@Override
	public BookingDetails createBooking(@Valid BookingDetails bookingDetails)
			throws DateFormatNotValidException, DatesNotValidException, CarNotAvailableException {

		LocalDateTime beginningDateTime = Utility.toLocalDateTime(bookingDetails.getBeginning());
		LocalDateTime endDateTime = Utility.toLocalDateTime(bookingDetails.getEnd());

		if (!Utility.isValidDates(beginningDateTime, endDateTime)) {
			log.debug("Provided dates are not valid! date from: {}, date to: {}", beginningDateTime, endDateTime);
			throw new DatesNotValidException("Provided dates are not valid!");
		}
		
		Car car = carRepo.findById(bookingDetails.getCarId()).get();
		
		if (!carDao.isAvailableWithinRentPeriod(car, beginningDateTime, endDateTime)) {
			throw new CarNotAvailableException("Car Not available within the rent period. Car ID: " + car.getId());
		}
		
		// create booking for user and car
		Booking booking = bookingDao.create(new Booking(beginningDateTime, endDateTime, car));

		BookingDetails details=new BookingDetails();
		details.setBeginning(booking.getBeginning().toString());
		details.setEnd(booking.getEnd().toString());
		details.setCar(booking.getCar());
		return details;
	}
}
