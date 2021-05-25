package com.example.demo.repositories;

import com.example.demo.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends MongoRepository<Car, Long> {
    List<Car> findCarByforSale(boolean forSale);
    boolean existsCarByManufacturerIgnoreCaseAndLicensePlateIgnoreCase(String manufacturer, String licensePlate);
}



