package main.java.hiber.service;

import main.java.hiber.model.Car;
import main.java.hiber.model.User;

import java.util.List;

public interface CarService {

    void add(Car car);

    List<Car> listCars();

}
