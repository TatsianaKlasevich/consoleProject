package com.klasevich.console.project.factory;

import com.klasevich.console.project.entity.PhoneNumber;
import com.klasevich.console.project.entity.Role;
import com.klasevich.console.project.entity.User;
import com.klasevich.console.project.util.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.klasevich.console.project.util.UsefulData.*;

public class UserFactoryImpl implements UserFactory {

    @Override
    public Optional<User> createUser(String line) {
        Optional<User> userOptional;
        List<String> userData = List.of(line.split(DELIMITER));
        String name = null;
        String surname = null;
        String email = null;
        String role = null;
        List<Role> roles = new ArrayList<>();
        List<PhoneNumber> phoneNumbers = new ArrayList<>();

        if (userData.size() >= 5 && userData.size() <= 7) {
            name = userData.get(FIRST_ELEMENT);
            surname = userData.get(SECOND_ELEMENT);
            email = userData.get(THIRD_ELEMENT);
            role = userData.get(FORTH_ELEMENT);

            if (!UserValidator.isValidName(name) || !UserValidator.isValidSurname(surname) ||
                    !UserValidator.isValidEmail(email) || !UserValidator.isValidRole(role)) {
                userOptional = Optional.empty();
                return userOptional;
            }

            roles = findRole(role);
            if (!UserValidator.isValidNumberOfRoles(roles)) {
                userOptional = Optional.empty();
                return userOptional;
            }
            for (int i = 4; i < userData.size(); i++) {
                String phoneString = userData.get(i);

                if (UserValidator.isValidPhoneNumber(phoneString)) {
                    PhoneNumber phoneNumber = new PhoneNumber(phoneString);
                    phoneNumbers.add(phoneNumber);
                } else {
                    userOptional = Optional.empty();
                    return userOptional;
                }
            }
        }
        userOptional = Optional.of(new User(name, surname, email, roles, phoneNumbers));
        return userOptional;
    }

    private List<Role> findRole(String role) {
        List<String> stringRoles = List.of(role.split(ROLE_DELIMITER));
        List<Role> roles = new ArrayList<>();

        for (String stringRole : stringRoles) {
            Role newRole = Role.valueOf(stringRole.toUpperCase(Locale.ROOT));
            roles.add(newRole);
        }
        return roles;
    }
}
