package main.java.hiber.service;

import main.java.hiber.model.Car;
import main.java.hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    User getUserByCarModelAndSeries(String model, int series);
}
