package com.project.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationManager {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
    private static final String FIRSTNAME_PATTER = "^[a-zA-Zа-яюА-ЯЮ]+$";

    public boolean isValidEmail(final String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidName(final String firstName) {
        pattern = Pattern.compile(FIRSTNAME_PATTER);
        matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
 }
