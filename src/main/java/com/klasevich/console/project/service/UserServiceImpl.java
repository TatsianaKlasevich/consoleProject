package com.klasevich.console.project.service;

import com.klasevich.console.project.entity.User;
import com.klasevich.console.project.factory.UserFactory;
import com.klasevich.console.project.factory.UserFactoryImpl;
import com.klasevich.console.project.view.UserView;
import com.klasevich.console.project.util.UserConverter;
import com.klasevich.console.project.util.UserValidator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.klasevich.console.project.util.UsefulData.FILE_PATH;

public class UserServiceImpl implements UserService {
    private UserFactory userFactory = new UserFactoryImpl();
    private UserView writer = new UserView();

    @Override
    public void addUser() {
        while (true) {
            System.out.println("Enter user data: ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            Optional<User> optionalUser = userFactory.createUser(line);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                writer.writeUserToFile(user);
                scanner.close();
                break;
            } else {
                System.out.println("Incorrect data!");
            }
        }
    }

    @Override
    public void changeUser() {
        System.out.print("Write user email: ");

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNext()) {
                String email = scanner.nextLine();

                if (UserValidator.isValidEmail(email)) {
                    findUserFromFileAndChange(email);
                } else {
                    System.out.println("Email is incorrect");
                    changeUser();
                }
            }
        }
    }

    @Override
    public void deleteUser() {
        System.out.print("Write user email: ");

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNext()) {
                String email = scanner.nextLine();

                if (UserValidator.isValidEmail(email)) {
                    deleteUserFromFile(email);
                } else {
                    System.out.println("Email is incorrect");
                    deleteUser();
                }
            }
        }
    }

    @Override
    public void readAllUsers() {
        writer.consoleOutput();
    }

    private void findUserFromFileAndChange(String email) {
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(FILE_PATH), StandardCharsets.UTF_8));

            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains(email)) {
                    System.out.println(fileContent.get(i));
                    System.out.println("Enter changed user data");

                    Scanner scanner = new Scanner(System.in);
                    String userData = scanner.nextLine();
                    String newLine = checkUserDataAndReturnLine(userData);

                    if (newLine.equals("")) {
                        findUserFromFileAndChange(email);
                    }

                    fileContent.set(i, newLine);
                    Files.write(Path.of(FILE_PATH), fileContent, StandardCharsets.UTF_8);
                    return;
                }
            }
            System.out.println("User hasn't found");
            changeUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String checkUserDataAndReturnLine(String userData) {
        String line;
        UserFactory userFactory = new UserFactoryImpl();

        Optional<User> userOptional = userFactory.createUser(userData);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            line = UserConverter.convertUserToString(user);
        } else {
            System.out.println("Enter correct data");
            line = "";

        }
        return line;
    }

    private void deleteUserFromFile(String email) {
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(FILE_PATH), StandardCharsets.UTF_8));

            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains(email)) {
                    System.out.println(fileContent.get(i));
                    fileContent.remove(i);
                    Files.write(Path.of(FILE_PATH), fileContent, StandardCharsets.UTF_8);
                    return;
                }
            }
            System.out.println("User hasn't found");
            deleteUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
