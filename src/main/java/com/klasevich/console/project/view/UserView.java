package com.klasevich.console.project.view;

import com.klasevich.console.project.entity.User;
import com.klasevich.console.project.util.UserConverter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.klasevich.console.project.util.UsefulData.FILE_PATH;

public class UserView {

    public void writeUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = UserConverter.convertUserToString(user);
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consoleOutput() {
        Path path = Paths.get(FILE_PATH);

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

