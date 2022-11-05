package org.itstep;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Java. Lesson031. Task01
 * User (login, password)
 *
 * @author Semenyuk Alexander
 * Date 02.11.2022
 * <p>
 * Задание 1.
 * Необходимо разработать приложение, которое позволит сохранять информацию
 * о логинах пользователей и их паролях.
 * Каждому пользователю соответствует пара логин — пароль.
 * При старте приложение отображается меню:
 * 1. Добавить нового пользователя.
 * 2. Удалить существующего пользователя.
 * 3. Проверить существует ли пользователь.
 * 4. Изменить логин существующего пользователя.
 * 5. Изменить пароль существующего пользователя.
 * В зависимости от выбора пользователя выполняется действие,
 * после чего меню отображается снова.
 * Для решения задачи используйте подходящий класс из Java Collections Framework.
 */
public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        String userName = "";
        String userLogin = "";
        String userPassword = "";
        String line = "";
        int n = -1;
        boolean rezultBoolean;
        User tmp = null;
        List<User> myUsers = new LinkedList<>();
        User user1 = new User("Макаренко Оксана Олеговна", "MakarenkoOO", "st5gh7sdfh");
        User user2 = new User("Патапенко Роман Александрович", "PatapenkoRA", "sdgfwerg78");
        User user3 = new User("Иванов Олег Михайлович", "IvanovOM", "erthrth678j");
        User user4 = new User("Сидоров Игорь Андреевич", "SidorovIA", "lkmpsdfg86");
        User user5 = new User("Сидоренко Мария Александровна", "SidorenkoMA", "retyjtfn97w");
        myUsers.add(user1);
        myUsers.add(user2);
        myUsers.add(user3);
        myUsers.add(user4);
        myUsers.add(user5);
        myUsers.remove(2);

        while (true) {
            System.out.println("-Menu ---------------------------------------------------------------------------------");
            System.out.println("1-add user (user / index, user), ");
            System.out.println("2-remove user (index / full name, login, password)");
            System.out.println("3-find user (user / full name, login, password)");
            System.out.println("4-change users login (index / full name, login, password)");
            System.out.println("5-change users password (index / full name, login, password)");
            System.out.println("9-print myUsers");
            System.out.println("0-exit");
            System.out.println("---------------------------------------------------------------------------------------");

            n = scanner.nextInt();
            switch (n) {
                case 1:     // Добавление объекта в список
                    tmp = null;
                    tmp = User.createUniqueUser(myUsers);
                    label1:
                    while (true) {
                        System.out.print("1 - index, 0 - end of list >>> ");
                        n = scanner.nextInt();
                        switch (n) {
                            case 1:
                                System.out.print("Введите индекс >>> ");
                                n = scanner.nextInt();
                                try {
                                    myUsers.add(n, tmp);
                                } catch (IndexOutOfBoundsException ex) {
                                    System.err.println("Вы не правильно ввели данные");
                                    break;
                                }
                                break label1;
                            case 0:
                                myUsers.add(tmp);
                                break label1;
                            default:
                                System.out.println("Вы не правильно ввели данные");
                                break;
                        }
                    }
                    break;
                case 2:     // Удаление объекта списка (по ФИО или login или password)
                    label2:
                    while (true) {
                        System.out.println("1 - remove by index, 0 - remove by full name, login, password");
                        n = scanner.nextInt();
                        switch (n) {
                            case 1:
                                System.out.print("Введите индекс >>> ");
                                n = scanner.nextInt();
                                try {
                                    myUsers.remove(n);
                                } catch (IndexOutOfBoundsException ex) {
                                    System.err.println("Вы не правильно ввели данные");
                                    break;
                                }
                                break label2;
                            case 0:
                                System.out.println(" Введите ФИО или login или password");
                                line = scanner1.nextLine();
                                myUsers.remove(User.find(myUsers, line));
                                break label2;
                            default:
                                System.out.println("Вы не правильно ввели данные");
                                break;
                        }
                    }
                    break;
                case 3:     // Наличие пользователя вв списке ()Проверка списка на наличие объекта (по ФИО или login или password)
                    tmp = null;
                    userName = "";
                    userLogin = "";
                    userPassword = "";
                    rezultBoolean = false;
                    label3:
                    while (true) {
                        System.out.println("1 - user existence check by user, 0 - user existence check by full name, login, password");
                        n = scanner.nextInt();
                        switch (n) {
                            case 1:
                                System.out.print("Введите ФИО пользователя >>> ");
                                userName = scanner1.nextLine();
                                System.out.print("Введите login пользователя >>> ");
                                userLogin = scanner1.nextLine();
                                System.out.print("Введите password пользователя >>> ");
                                userPassword = scanner1.nextLine();
                                tmp = new User(userName, userLogin, userPassword);
                                break label3;
                            case 0:
                                System.out.println("Введите ФИО или login или password");
                                line = scanner1.nextLine();
                                tmp = User.find(myUsers, line);
                                break label3;
                            default:
                                System.out.println("Вы не правильно ввели данные");
                                break;
                        }
                    }
                    rezultBoolean = User.userIncludeInList(myUsers, tmp);
                    if (rezultBoolean) {
                        System.out.println("User include in the list");
                    } else {
                        System.out.println("User don't include in the list");
                    }
                    break;
                case 4:     // Изменить логин существующего пользователя.
                    tmp = null;
                    userLogin = "";
                    label4:
                    while (true) {
                        System.out.println("1 - change login by index, 0 - change login by full name, login, password");
                        n = scanner.nextInt();
                        switch (n) {
                            case 1:
                                System.out.print("Введите индекс >>> ");
                                n = scanner.nextInt();
                                Label41:
                                while (true) {
                                    System.out.print("Введите новый login >>> ");
                                    userLogin = scanner1.nextLine();
                                    if (!User.checkLoginAndPassword(myUsers, userLogin)) {
                                        try {
                                            myUsers.get(n).setLogin(userLogin);
                                        } catch (IndexOutOfBoundsException ex) {
                                            System.err.println("Вы не правильно ввели данные");
                                        }
                                        break Label41;
                                    }
                                }
                                break label4;
                            case 0:
                                System.out.println("Введите ФИО или login или password изменяемого пользователя");
                                line = scanner1.nextLine();
                                tmp = User.find(myUsers, line);
                                Label42:
                                while (true) {
                                    System.out.print("Введите новый login >>> ");
                                    userLogin = scanner1.nextLine();
                                    if (!User.checkLoginAndPassword(myUsers, userLogin)) {
                                        tmp.setLogin(userLogin);
                                        break Label42;
                                    }
                                }
                                break label4;
                            default:
                                System.out.println("Вы не правильно ввели данные");
                                break;
                        }
                    }
                    break;
                case 5:// Изменить пароль существующего пользователя.
                    tmp = null;
                    userPassword = "";
                    label5:
                    while (true) {
                        System.out.println("1 - change password by index, 0 - change password by full name, login, password");
                        n = scanner.nextInt();
                        switch (n) {
                            case 1:
                                System.out.print("Введите индекс >>> ");
                                n = scanner.nextInt();
                                Label51:
                                while (true) {
                                    System.out.print("Введите новый password >>> ");
                                    userPassword = scanner1.nextLine();
                                    if (!User.checkLoginAndPassword(myUsers, userPassword)) {
                                        try {
                                            myUsers.get(n).setPassword(userPassword);
                                        } catch (IndexOutOfBoundsException ex) {
                                            System.err.println("Вы не правильно ввели данные");
                                        }
                                        break Label51;
                                    }
                                }
                                break label5;
                            case 0:
                                System.out.println("Введите ФИО или login или password изменяемого пользователя");
                                line = scanner1.nextLine();
                                tmp = User.find(myUsers, line);
                                Label52:
                                while (true) {
                                    System.out.print("Введите новый password >>> ");
                                    userPassword = scanner1.nextLine();
                                    if (!User.checkLoginAndPassword(myUsers, userPassword)) {
                                        tmp.setPassword(userPassword);
                                        break Label52;
                                    }
                                }
                                break label5;
                            default:
                                System.out.println("Вы не правильно ввели данные");
                                break;
                        }
                    }
                    break;
                case 9:
                    System.out.println("My users (Full name, login, password)");
                    for (User user : myUsers) {
                        System.out.println(user);
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Вы неправильно ввели исходные данные");
                    break;
            }
        }

    }
}
