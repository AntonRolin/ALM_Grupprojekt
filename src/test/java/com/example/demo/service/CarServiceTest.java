package com.example.demo.service;

import com.example.demo.models.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    @Test
    public void getPrice(){
        Car car = new Car();
        car.setProductionyear(2015);
        car.setInitialPrice(100000);



        assertEquals(53144, 2);
    }
}