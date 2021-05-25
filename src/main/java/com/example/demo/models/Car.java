package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    String id;
    String manufacturer;
    String licensePlate;
    int productionyear;
    boolean cleantitle;
    boolean forSale;
    String model;
    String color;
    int productionyear;
}
