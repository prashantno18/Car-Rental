package com.demo.car.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.car.rental.entity.Car;
import com.demo.car.rental.repository.ICarRepository;

@Service
public class CarService implements ICarService {
	
	@Autowired
	ICarRepository carRepo;

	@Override
	public List<Car> getList() {
		return carRepo.findAll();
		 
	}

	@Override
	public Car getListById(Long id) {
		return carRepo.findById(id).get();
	}

}
