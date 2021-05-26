package com.example.demo.repositories;

import com.example.demo.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends MongoRepository<Car, Long> {
    List<Car> findManufacturerByLicensePlate(String licensePlate);
    List<Car> findLicensePlateByColor(String color);
}



