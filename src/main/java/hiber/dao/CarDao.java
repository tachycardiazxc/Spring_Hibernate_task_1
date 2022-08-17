package main.java.hiber.dao;

import main.java.hiber.model.Car;
import java.util.List;

public interface CarDao {

    void add(Car car);

    List<Car> listCars();

}
