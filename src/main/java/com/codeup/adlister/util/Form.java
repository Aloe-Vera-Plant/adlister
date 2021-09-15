package com.codeup.adlister.util;

import com.codeup.adlister.dao.DaoFactory;

public class Form {
    public static boolean hasEmptyInputs(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].trim().isEmpty()) return true;
        }

        return false;
    }

    public static boolean unconfirmedPassword(String password, String passwordConfirmation) {
        return !password.equals(passwordConfirmation);
    }

    public static boolean usernameIsTaken(String username) {
        return DaoFactory.getUsersDao().findByUsername(username) != null;
    }
}
