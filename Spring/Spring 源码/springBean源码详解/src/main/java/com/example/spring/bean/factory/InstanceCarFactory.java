package com.example.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
    private Map<String, Car> cars;

    public InstanceCarFactory() {
        cars = new HashMap<>();
        cars.put("audi", new Car("Audi", 108012323));
        cars.put("ford", new Car("Ford", 1237891293));
    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }
}
