package com.demo.car.rental.service;

import java.util.List;

import com.demo.car.rental.entity.Car;

public interface ICarService {

	List<Car> getList();

	Car getListById(Long id);

}
