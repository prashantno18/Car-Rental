package com.demo.car.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.car.rental.entity.Booking;


public interface IBookingRepository extends JpaRepository<Booking, Integer>{

}
