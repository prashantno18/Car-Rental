package com.demo.car.rental.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.car.rental.entity.Car;
import com.demo.car.rental.rest.ICar;

public class CarTest {

	@Autowired
	ICar car;
	
	@Test
	public void getCarList() {
		List<Car> list = car.getList();
		assertEquals(4, list.size());
	}
	@Test
	public void getCarListById() {
		Long id = 1L;
		Car listById = car.getListById(id);
		assertEquals("Toyota camry", listById.getModel());
	}
	@Test
	public void getCarListByWrongId() {
		Long id = 83L;
		try {
			Car listById = car.getListById(id);
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("No value present"));
		}
	}
}
