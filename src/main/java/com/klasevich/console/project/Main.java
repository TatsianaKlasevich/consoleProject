package com.klasevich.console.project;

import com.klasevich.console.project.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter action");
            System.out.println("0 - create new user, 1 - change user, 2 - delete user, 3 - read user info, another symbol - finish ");
            while (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                switch (i) {
                    case 0:
                        userService.addUser();
                        break;
                    case 1:
                        userService.changeUser();
                        break;
                    case 2:
                        userService.deleteUser();
                        break;
                    case 3:
                        userService.readAllUsers();
                        break;
                    default:
                        return;
                }
            }
        }
    }
}
