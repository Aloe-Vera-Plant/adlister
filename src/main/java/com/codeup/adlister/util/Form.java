package com.codeup.adlister.util;

public class Form {
    public static boolean hasEmptyInputs(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].isEmpty()) return true;
        }

        return false;
    }

    public static boolean unconfirmedPassword(String password, String passwordConfirmation) {
        return !password.equals(passwordConfirmation);
    }
}
