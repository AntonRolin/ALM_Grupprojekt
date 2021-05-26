package com.example.demo.service;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;

    public List<Car> getCars() {
        return repository.findAll();
    }

    public void saveNewCar(Car car) {
        repository.save(car);
    }


    public int getPrice(Car car, int year) {
        double initialPrice = car.getInitialPrice();
        int productionyear = car.getProductionyear();
        int carAge = year - productionyear;
        double price = initialPrice;

        if (carAge > 0) {
            for (int i = 0; i < carAge; i++) {
                price = price * 0.9;
            }
        }

        return (int) price;
    }
}