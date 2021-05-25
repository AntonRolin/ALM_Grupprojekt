package com.example.demo.repository;


import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class CarRepositoryTest {

    // vår klass vi vill testa
    @Autowired
    CarRepository carRepository;

    @Test
    void existsCarByManufacturerIgnoreCaseAndLicensePlateIgnoreCase() {
        String expectedCarName = "BMW";
        String expectedLicensePlate = "MLB23C";

        Car savingCar = new Car();
        savingCar.setManufacturer(expectedCarName);
        savingCar.setLicensePlate(expectedLicensePlate);

        carRepository.save(savingCar);
        // ---------------------------

        boolean actual = carRepository.existsCarByManufacturerIgnoreCaseAndLicensePlateIgnoreCase(expectedCarName, expectedLicensePlate);

        // ---------------------------

        assertTrue(actual);
    }


    @Test
    void findCarByforSaleAndCleanTitle() {
        String expectedLicensePlate = "VLB23C";
        boolean expectedCleantitle = true;
        boolean expectedForSale = true;

        Car carOne = new Car();
        carOne.setLicensePlate(expectedLicensePlate);
        carOne.setCleantitle(expectedCleantitle);
        carOne.setForSale(expectedForSale);



        carRepository.save(carOne);

        List<Car> actual = carRepository.findCarByforSaleAndCleanTitle(true, true);

        assertEquals(carOne.getLicensePlate(), actual.get(0).getLicensePlate());


    }
}
