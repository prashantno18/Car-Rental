package com.demo.car.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.car.rental.entity.Car;


public interface ICarRepository extends JpaRepository<Car, Long> {

}
