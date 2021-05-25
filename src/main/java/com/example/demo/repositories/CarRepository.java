package com.example.demo.repositories;

import com.example.demo.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findCarByforSale(boolean forSale);
    boolean existsCarByManufacturerIgnoreCaseAndLicensePlateIgnoreCase(String author, String title);
}
