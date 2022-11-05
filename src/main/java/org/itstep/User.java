package org.itstep;

import java.util.List;
import java.util.Scanner;

public class User {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner1 = new Scanner(System.in);
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Имена могут повторяться, login и password - нет
    @Override
    public boolean equals(Object o) {
        if (o instanceof User user) {
            return login.equals(user.login) && password.equals(user.password);
        }
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static User createUniqueUser(List<User> users) {
        boolean log = true;
        boolean pas = true;
        User tmp = null;
        System.out.print("Введите ФИО пользователя >>> ");
        String userName = scanner1.nextLine();
        String userLogin = "";
        String userPassword = "";
        while (true) {
            if (log) {
                System.out.print("Введите login пользователя >>> ");
                userLogin = scanner1.nextLine();
            }
            if (!checkLoginAndPassword(users, userLogin)){
                log = false;
                break;
            }
        }

        while (true) {
            if (pas) {
                System.out.print("Введите password пользователя >>> ");
                userPassword = scanner1.nextLine();
            }
            if (!checkLoginAndPassword(users, userPassword)){
                pas = false;
                break;
            }
        }
        tmp = new User(userName, userLogin, userPassword);
        return tmp;
    }

    public static boolean checkLoginAndPassword (List<User> users, String line){
        boolean condition = false;
        for (User user : users) {
            if (user.login.equals(line) || user.password.equals(line) ){
                System.out.println("Пользователь с такими данными уже существует: " + user);
                condition = true;
            }
        }
        return condition;
    }



    // Поиск по ФИО, login, password
    // По ФИО, password - вывод пользователей, просьба введите login, возврат объекта по login
    // login - возврат объекта по login
    public static User find (List<User> users, String line) {
        boolean condition = false;
        User tmp = null;
        for (User user : users) {
            if (user.name.equals(line) || user.password.equals(line)) {
                System.out.println("Пользователь: " + user);
                condition = true;
            }
        }
        if (condition) {
            System.out.print("Введите login пользователя >>> ");
            line = scanner1.nextLine();
            condition = false;
        }

        for (User user : users) {
            if (user.login.equals(line)) {
                tmp = user;
                condition = true;
                break;
            }
        }
        if (condition){
            System.out.println("По Вашему запросу найден такой пользователь: " + tmp);
            return tmp;
        } else {
            System.out.println("Такого пользователя нет в списке");
        }
        return tmp;
    }


    public static boolean userIncludeInList(List<User> users, User o) {
        boolean condition = false;
        for (User user : users) {
            if (user.name.equals(o.name) || user.login.equals(o.login) || user.password.equals(o.password) ){
                System.out.println(user);
                condition = true;
            }
        }
        return condition;
    }




}
