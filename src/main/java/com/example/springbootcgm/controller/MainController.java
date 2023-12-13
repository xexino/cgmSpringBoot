package com.example.springbootcgm.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.springbootcgm.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class MainController {

    @Autowired
    private List<Car> listAuto; // Inject the list directly


    @GetMapping("/v1/cars") // http://localhost:8091/v1/cars?brand=TOYOTA
    public String car(@RequestParam String brand){
        return "Questa è una "+brand;
    }



    @PatchMapping(value = "/v1/cars")
    public List<Car> partialUpdateCar(@RequestParam String model){

//        Nella lista cars modificare il model del terzo elemento
        listAuto.get(2).setModel(model);
        return listAuto;
    }

    @PatchMapping(value = "/v2/cars")
    public List<Car> updateTheEntireThirdElement(@RequestParam  String brand ,String model ,String color){

        listAuto.get(2).setBrand(brand);
        listAuto.get(2).setModel(model);
        listAuto.get(2).setColor(color);

        return listAuto;
    }


    @GetMapping("/v2/cars/{brand}") // http://localhost:8091/v2/cars/TOYOTA
    public String car2(@PathVariable String brand){
        return "Questa è una "+brand;
    }

    @GetMapping("/v3/cars") // http://localhost:8091/v3/cars
    public Car car3(){
        return new Car("CITROEN", "C5", "Black");
    }


    @GetMapping("/v4/cars") // http://localhost:8091/v4/cars
    public List<Car> car4(){
        return listAuto.isEmpty() ? null : listAuto;
    }

    @PostMapping("/v5/cars")
    public List<Car> createCar(@RequestBody  Car newCar){
        List<Car> carList = new ArrayList<>(); // Create a new list
        carList.addAll(listAuto);

        carList.add(newCar);

        return carList;
    }


    @DeleteMapping("/v1/deleteLast")
    public  List<Car> removeCar(){
        List<Car> carList = new ArrayList<>(); // Create a new list
        carList.addAll(listAuto);
        carList.remove(carList.size() -1);
        return carList;
    }

}
