package com.klasevich.console.project.factory;

import com.klasevich.console.project.entity.User;

import java.util.Optional;

public interface UserFactory {
    Optional<User> createUser(String line);
}
