package com.klasevich.console.project.util;

import java.util.regex.Pattern;

public class UsefulData {
    public final static String FILE_PATH = "data/users.txt";
    public static final String DELIMITER = " ";
    public static final String ROLE_DELIMITER = "\\+";
    public static final int FIRST_ELEMENT = 0;
    public static final int SECOND_ELEMENT = 1;
    public static final int THIRD_ELEMENT = 2;
    public static final int FORTH_ELEMENT = 3;
    public static final Pattern NAME_REGEX = Pattern.compile("([а-яА-Яa-z A-Z]+){2,30}");
    public static final Pattern SURNAME_REGEX = Pattern.compile("([а-яА-Яa-z A-Z]+){2,30}");
    public static final Pattern EMAIL_REGEX = Pattern.compile("[-\\w]{4,30}@[a-zA-Z]+\\.[a-zA-Z]{2,3}");
    public static final Pattern PHONE_REGEX = Pattern.compile("375\\d{9}");

    private UsefulData() {
    }
}
