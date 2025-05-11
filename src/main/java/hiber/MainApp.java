package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


//        Добавление в таблицу

        userService.add(new User("User1", "Lastname1", "user1@mail.ru",
                new Car("VOLVO", 1111)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru",
                new Car("BMW", 2222)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru",
                new Car("MERS", 3333)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru",
                new Car("AUDI", 4444)));


//        Вывод всех пользователей с машинами

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }


////        Вывод только пользователей
//
//        List<User> users2 = userService.listUsers();
//        for (User user : users2) {
//            System.out.println(user);
//        }
//
//
////        Вывод только машин
//
//        List<Car> cars = userService.listCars();
//        for (Car car : cars) {
//            System.out.println(car);
//        }


//        Вывод пользователя по моделе и серии машины

        System.out.println(userService.getUserByModelAndSeriesCar("BMW", 2222));

        context.close();
    }
}
