package com.example.demo.repository;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class CarRepositoryTest {


    @Autowired
    CarRepository carRepository;

    private Car carOne;

    @BeforeEach
    void init() {
        carOne = new Car();
        carOne.setManufacturer("BMW");
        carOne.setLicensePlate("VLB23C");
        carOne.setColor("Red");
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
        List<Car> actual = carRepository.findLicensePlateByColor(carOne.getColor());
        assertEquals(carOne.getColor(), actual.get(0).getColor());
    }
}
