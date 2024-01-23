import model.User;
import service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserService service = new UserService(scanner);


        while (true) {
            menu();
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 0 -> {
                    return;
                }
                case 1 -> service.create();
                case 2 -> service.printAll();
                case 3 -> service.findById();
                case 4 -> service.findByName();
                case 5 -> service.deleteUserById();
                case 6 -> service.updateUserById();
            }
        }

//        //1. Достать пользователя по id
//        System.out.println(manager.find(User.class, 1));
//
//        //2. Достать всех пользователей
//        List<User> users = manager.createQuery("select u from User u", User.class).getResultList();
//        System.out.println(users);
//
//        //3. Создать пользователя
//        try {
//            manager.getTransaction().begin();
//            User user = new User();
//            user.setName("userFromJPA");
//            user.setEmail("userFromJPA@gmail.com");
//            user.setAge(22);
//            manager.persist(user);
//            manager.getTransaction().commit();
//            System.out.println("Пользователь создан");
//        } catch (Exception e) {
//            manager.getTransaction().rollback();
//            System.out.println(e.getMessage());
//        }
//
//        //4. Обновить данные пользователя
//        try {
//            manager.getTransaction().begin();
//            User user = manager.find(User.class, 2);
//            user.setAge(user.getAge() + 1);
//            manager.merge(user);
//            manager.getTransaction().commit();
//            System.out.println("Пользователь обновлен");
//        } catch (Exception e) {
//            manager.getTransaction().rollback();
//            System.out.println(e.getMessage());
//        }
//
//        //5. Удалить пользователя
//        try {
//            manager.getTransaction().begin();
//            User user = manager.find(User.class, 2);
//            manager.remove(user);
//            manager.getTransaction().commit();
//            System.out.println("Пользователь удален");
//        } catch (Exception e) {
//            manager.getTransaction().rollback();
//            System.out.println(e.getMessage());
//        }
    }

    private static void menu() {
        System.out.println("1. Создать пользователя");
        System.out.println("2. Вывести всех пользователей");
        System.out.println("3. Найти пользователя по Id");
        System.out.println("4. Найти пользователя по имя");
        System.out.println("5. Удалить пользователя по Id");
        System.out.println("6. Обновить данные пользователя по Id");
    }
}