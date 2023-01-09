package com.demo.car.rental.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.car.rental.entity.Booking;
import com.demo.car.rental.entity.Car;

@Repository
public class CarDao implements ICarDao {

	@Transactional
	@Override
	public boolean isAvailableWithinRentPeriod(Car car, LocalDateTime rentFrom, LocalDateTime rentTo) {
		if(car.getAvailableFrom() == null || car.getAvailableTo() == null 
				|| !isDateTimeWithinPeriod(rentFrom, car.getAvailableFrom(), car.getAvailableTo())
				|| !isDateTimeWithinPeriod(rentTo, car.getAvailableFrom(), car.getAvailableTo())) {
			return false;
		}
	
		return !hasCurrentBooking(car, rentFrom, rentTo);
	}
	
	private boolean isDateTimeWithinPeriod(LocalDateTime dateTime, LocalDateTime rentFrom, LocalDateTime rentTo) {
		return dateTime.compareTo(rentFrom) >= 0 && dateTime.compareTo(rentTo) <= 0;
	}
	
	private boolean hasCurrentBooking(Car car, LocalDateTime rentFrom, LocalDateTime rentTo) {
		List<Booking> bookings = car.getBookings();
		for (Booking booking : bookings) {
			if (isDateTimeWithinPeriod(booking.getBeginning(), rentFrom, rentTo) 
					|| isDateTimeWithinPeriod(booking.getEnd(), rentFrom, rentTo)) {
				return true;
			}
		}
		return false;
	}

}
