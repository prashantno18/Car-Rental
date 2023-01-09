package com.demo.car.rental.dao;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.car.rental.entity.Booking;
import com.demo.car.rental.exception.CarNotAvailableException;
import com.demo.car.rental.repository.IBookingRepository;

@Repository
public class BookingDao implements IBookingDao{
	
	@Autowired
	IBookingRepository bookingRepo;

	@Transactional
	@Override
	public Booking create(@NotNull Booking booking) throws CarNotAvailableException {
		return bookingRepo.saveAndFlush(booking);
	}

}
