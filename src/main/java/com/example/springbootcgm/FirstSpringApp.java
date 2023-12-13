package com.example.springbootcgm;
import com.example.springbootcgm.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FirstSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringApp.class, args);
    }


    @Bean(name = "listAuto")
    public List<Car> listAuto() {
        // Create and return a list of cars
        return Arrays.asList(
        new Car("BMW", "M3", "Blue"),
        new Car("TOYOTA", "RAV4", "White"),
        new Car("FIAT", "500", "Pink"),
        new Car("MERCEDES", "GL400", "Grey"),
        new Car("MAZDA", "M5", "Orange"),
        new Car("PEUGEOT", "5008", "Green")
        );
    }


}
