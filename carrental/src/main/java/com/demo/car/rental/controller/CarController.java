package com.demo.car.rental.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.car.rental.entity.Car;
import com.demo.car.rental.rest.ICar;
import com.demo.car.rental.service.ICarService;

@RestController
@RequestMapping("car")
public class CarController implements ICar{
	
	private Logger log = LogManager.getLogger(CarController.class);
	
	@Autowired
	ICarService carService;

	@Override
	@GetMapping(path ="/getList",produces = "application/json")
	public List<Car> getList() {
		return carService.getList();
	}
	
	@Override
	@GetMapping(path ="/getListById/{id}",produces = "application/json")
	public Car getListById(@PathVariable("id") Long id) {
		
		log.info("value of id is,{}",id);
		return carService.getListById(id);
	}

}
