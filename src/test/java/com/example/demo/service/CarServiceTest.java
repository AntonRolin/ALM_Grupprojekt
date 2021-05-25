package com.example.demo.service;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class) // Junit 5
public class CarServiceTest {
    // klass vi vill testa
    CarService carService;

    @Mock
    CarRepository mockRepository;

    @BeforeEach
    public void init() {
        carService = new CarService(mockRepository);
    }

    @Test
    void getAll() {
        Car mockCar = new Car();
        mockCar.setManufacturer("Volvo");
        String expectedModel = "V40";

        mockCar.setManufacturer(expectedModel);

        when(mockRepository.findAll())
                .thenReturn(Collections.singletonList(mockCar));

        //        ------------------------------------


        // anropa våran metod
        List<Car> actual = carService.getCars();

//        ------------------------------------

        assertEquals(mockCar.getModel(), actual.get(0).getModel());
        assertEquals(expectedModel, actual.get(0).getManufacturer());
        assertEquals(1, actual.size());

        verify(mockRepository).findAll();
    }
}