package com.example.demo.repository;


import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class CarRepositoryTest {

    // vår klass vi vill testa
    @Autowired
    CarRepository carRepository;

    @Test
    void existsCarByNameIgnoreCaseAndLicensePlateIgnoreCase() {
        String expectedCarName = "Volvo";
        String expectedLicensePlate = "MLB98L";

        Car savingCar = new Car();
        savingCar.setManufacturer(expectedCarName);
        savingCar.setLicensePlate(expectedLicensePlate);

        carRepository.save(savingCar);
        // ---------------------------

        boolean actual = carRepository.existsCarByManufacturerIgnoreCaseAndLicensePlateIgnoreCase(expectedLicensePlate, expectedCarName);

        // ---------------------------

        assertTrue(actual);
    }
}
