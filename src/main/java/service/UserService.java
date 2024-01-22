package service;

import dao.UserDao;
import lombok.Getter;
import model.User;

import java.util.List;
import java.util.Scanner;

@Getter
public class UserService {
    private final UserDao userDao;
    private final Scanner scanner;

    public UserService(Scanner scanner) {
        this.userDao = new UserDao();
        this.scanner = scanner;
    }

    public void findById() {
        System.out.println("Введите id пользователя:");
        int id = Integer.parseInt(scanner.nextLine());
        User user = userDao.findById(id);
        if (user == null) {
            System.out.println("Пользователь с данным id не найден");
            return;
        }

        System.out.println(user);
    }
}