package com.example.demo.repository;


import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(MockitoExtension.class)
public class CarRepositoryTest {


    @Autowired
    CarRepository carRepository;

    private Car carOne;

    @BeforeEach
    void init() {
        carOne = new Car();
        carOne.setLicensePlate("VLB23C");
        carOne.setForSale(true);
        carOne.setManufacturer("BMW");
        carRepository.save(carOne);
    }

    @Test
    @DisplayName("Test passed if car has correct plate")
    void findManufacturerByLicensePlate() {
        List<Car> actual = carRepository.findManufacturerByLicensePlate(carOne.getLicensePlate());
        assertEquals(carOne.getLicensePlate(), actual.get(0).getLicensePlate());
    }


    @Test
    @DisplayName("Test passed if car is forsale")
    void findCarByforSale() {
        List<Car> actual = carRepository.findCarByforSale(true);
        assertEquals(Collections.singletonList(carOne), actual);
    }
}
