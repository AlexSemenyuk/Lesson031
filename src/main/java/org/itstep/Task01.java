package org.itstep;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

        String userName;
        String userLogin;
        String userPassword;
        int n = -1;
        boolean rezultBoolean;
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

//        User user = myUsers.get(3);
//        System.out.println(user);

//        Iterator <User> iterator = myUsers.iterator();

//        while (iterator.hasNext()) {		// Перебор элементов в обратном порядке
////            System.out.println(iterator.next());
//            iterator.next();
//            iterator.remove();
//        }
//
//        for (User user: myUsers){
//            System.out.println(user);
//        }


        while (true) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("1-add user, 2-remove user, 3-check user, 4-change users login, 5-change users password");
            System.out.println("9-print myUsers, 0-exit");
            n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Введите ФИО пользователя");
                    userName = scanner1.nextLine();
                    System.out.println("userName = " + userName);
                    System.out.println("Введите login пользователя");
                    userLogin = scanner1.nextLine();
                    System.out.println("userLogin = " + userLogin);
                    System.out.println("Введите password пользователя");
                    userPassword = scanner1.nextLine();
                    System.out.println("userPassword = " + userPassword);
                    try {
                        rezultBoolean = myUsers.add(new User(userName, userLogin, userPassword));
                        if (rezultBoolean) {
                            System.out.println("User add success");
                        } else {
                            System.out.println("User add wrong");
                        }
                    } catch (ClassCastException | NullPointerException | UnsupportedOperationException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    Iterator <User> iterator = myUsers.iterator();
                    System.out.println("Введите ФИО пользователя");
                    userName = scanner.nextLine();
                    scanner.nextLine();
                    while (iterator.hasNext()){
                        iterator.next();
                        User tmp = iterator.next();
                        if (tmp.getName().equals(userName)){
                            try {
//                                iterator.remove();
                                rezultBoolean=  myUsers.remove(tmp);
                                if (rezultBoolean) {
                                    System.out.println("User remove success");
                                } else {
                                    System.out.println("User remove wrong");
                                }
                            } catch (NullPointerException | ClassCastException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    break;
                case 3:
                    // Проверить существует ли пользователь.
                    break;
                case 4:
                    // Изменить логин существующего пользователя.
                    break;
                case 5:
                    // Изменить пароль существующего пользователя.
                    break;
                case 9:
                    System.out.println("My users (Full name (Login, Password))");
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
