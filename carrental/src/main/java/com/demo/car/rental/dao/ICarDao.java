package com.demo.car.rental.dao;

import java.time.LocalDateTime;

import com.demo.car.rental.entity.Car;

public interface ICarDao {

	boolean isAvailableWithinRentPeriod(Car car, LocalDateTime beginningDateTime, LocalDateTime endDateTime);

}
