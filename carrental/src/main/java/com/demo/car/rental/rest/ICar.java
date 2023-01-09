package com.demo.car.rental.rest;

import java.util.List;

import com.demo.car.rental.entity.Car;


public interface ICar {

	public List<Car> getList();

	Car getListById(Long id); 
	
}
