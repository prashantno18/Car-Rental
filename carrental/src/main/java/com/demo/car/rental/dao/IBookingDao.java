package com.demo.car.rental.dao;

import com.demo.car.rental.entity.Booking;
import com.demo.car.rental.exception.CarNotAvailableException;

public interface IBookingDao {

	Booking create(Booking booking) throws CarNotAvailableException;

}
