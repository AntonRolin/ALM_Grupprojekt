package com.example.demo.service;
import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getCarsForSale() {
        // hämtar alla Cars som är till försäljning
        List<Car> selableCar = repository.findCarByforSale(true);

        // returnerar endast Food namnen i en lista
        return selableCar.stream()
                .map(Car::getManufacturer)
                .collect(Collectors.toList());
    }


}