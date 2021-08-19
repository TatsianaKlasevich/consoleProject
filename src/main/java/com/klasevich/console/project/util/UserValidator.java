package com.klasevich.console.project.util;

import com.klasevich.console.project.entity.Role;

import java.util.List;
import java.util.regex.Matcher;

import static com.klasevich.console.project.util.UsefulData.*;

public class UserValidator {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            System.out.println("Please enter valid phone number");
            return false;
        }
        Matcher matcher = PHONE_REGEX.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isValidName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Please enter valid name");
            return false;
        }
        Matcher matcher = NAME_REGEX.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            System.out.println("Please enter valid surname");
            return false;
        }
        Matcher matcher = SURNAME_REGEX.matcher(surname);
        return matcher.matches();
    }

    public static boolean isValidEmail(String mail) {
        if (mail == null || mail.isBlank()) {
            System.out.println("Please enter valid email");
            return false;
        }
        Matcher matcher = EMAIL_REGEX.matcher(mail);
        return matcher.matches();
    }

    public static boolean isValidRole(String role) {
        boolean result = true;
        if (role == null || role.isBlank()) {
            System.out.println("Please enter valid role");
            result = false;
        }
        return result;
    }

    public static boolean isValidNumberOfRoles(List<Role> roles) {
        boolean result = false;
        if (roles.size() == 1) {
            if (roles.get(0).getLevel() == 3)
                result = true;
        }
        if (roles.size() == 2) {
            if (roles.get(0).getLevel() == 1 && roles.get(1).getLevel() == 2
                    || roles.get(0).getLevel() == 2 && roles.get(1).getLevel() == 1)
                result = true;
        }
        return result;
    }
}
