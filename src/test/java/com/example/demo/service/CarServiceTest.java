package com.example.demo.service;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {
    CarService carService;

    @Autowired
    CarRepository carRepository;

    @BeforeEach
    public void init(){
        carService = new CarService(carRepository);
    }

    @Test
    public void getPrice(){
        int initialPrice = 100000;
        int productionyear = 2015;

        Car car = new Car();
        car.setProductionyear(productionyear);
        car.setInitialPrice(initialPrice);

        int x = carService.getPrice(car, 2021);

        assertEquals(53144, x);
    }

    @Test
    @DisplayName("Negative year difference returns initial price")
    public void getPriceNegativeAge(){
        int initialPrice = 50000;
        int productionyear = 2010;

        Car car = new Car();
        car.setProductionyear(productionyear);
        car.setInitialPrice(initialPrice);

        int x = carService.getPrice(car, 2008);

        assertEquals(50000, x);
    }
}