package main.java.hiber;

import main.java.hiber.config.AppConfig;
import main.java.hiber.model.Car;
import main.java.hiber.model.User;
import main.java.hiber.service.CarService;
import main.java.hiber.service.UserService;
import main.java.hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      carService.add(new Car("x", 123));
      carService.add(new Car("y", 1234));
      carService.add(new Car("z", 12345));
      carService.add(new Car("w", 123456));

      List<Car> cars = carService.listCars();

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", cars.get(0)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
      }

      User user = userService.getUserByCarModelAndSeries("x", 123);
      System.out.println("Id = "+user.getId());
      System.out.println("First Name = "+user.getFirstName());
      System.out.println("Last Name = "+user.getLastName());
      System.out.println("Email = "+user.getEmail());
      System.out.println("Car = "+user.getCar());

      context.close();
   }
}
