package com.example.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("audi", new Car("Audi", 108012323));
        cars.put("ford", new Car("Ford", 1237891293));
    }

    // 静态工厂方法，不需要创建StaticCarFactory对象的情况下，通过该方法可以得到对应的实例
    public static Car getCar(String brand) {
        return cars.get(brand);
    }
}
