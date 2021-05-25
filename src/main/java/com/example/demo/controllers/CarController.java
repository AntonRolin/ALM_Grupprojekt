package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService service;

    @GetMapping("/Cars")
    public List<Car> getCars() {
        return service.getCars();
    }

    @PostMapping("/Cars")
    public void saveNewCar(@RequestBody Car car) {
        service.saveNewCar(car);
    }

    @GetMapping("/Cars/forsale")
    public List<String> getSelableCars() {
        return service.getCarsForSale();
    }
}


