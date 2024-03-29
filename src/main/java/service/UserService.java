package service;

import dao.UserDao;
import lombok.Getter;
import model.User;

import java.util.Scanner;

@Getter
public class UserService {
    private final UserDao userDao;
    private final Scanner scanner;

    public UserService(Scanner scanner) {
        this.userDao = new UserDao();
        this.scanner = scanner;
    }

    public void create() {
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();

        System.out.println("Введи электронную почту:");
        String email = scanner.nextLine();

        System.out.println("Введи возраст:");
        int age = Integer.parseInt(scanner.nextLine());

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);

        userDao.create(user);
    }

    public void printAll() {
        userDao.findAll();
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

    public void findByName() {
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();
        User user = userDao.findByName(name);
        if (user == null) {
            System.out.println("Пользователь с данным именем не найден");
            return;
        }
        System.out.println(user);
    }

    public void deleteUserById() {
        System.out.println("Введите ID пользователя:");
        int id = Integer.parseInt(scanner.nextLine());
        int user = userDao.deleteById(id);
    }

    public void updateUserById() {
        System.out.println("Введите ID пользователя:");
        int id = Integer.parseInt(scanner.nextLine());
        User user = userDao.update(userDao.findById(id));
    }

    public void updateUserEmail() {
        System.out.println("Введите ID пользователя:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите новое значение электронной почты пользователя пользователя:");
        String newEmail = scanner.nextLine();
        userDao.updateEmail(userDao.findById(id), newEmail);
    }
}