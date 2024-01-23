import service.UserService;

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
                case 7 -> service.updateUserEmail();
            }
        }
    }

    private static void menu() {
        System.out.println("-----------------------------------------------");
        System.out.println("1. Создать пользователя");
        System.out.println("2. Вывести всех пользователей");
        System.out.println("3. Найти пользователя по Id");
        System.out.println("4. Найти пользователя по имя");
        System.out.println("5. Удалить пользователя по Id");
        System.out.println("6. Обновить данные пользователя по Id");
        System.out.println("7. Обновить электронную почту пользователя по Id");
        System.out.println("*** Для выхода введите цифру 0");
        System.out.println("-----------------------------------------------");
    }
}