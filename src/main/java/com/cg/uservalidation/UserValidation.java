package com.cg.uservalidation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvalidException extends Exception {
    public InvalidException() {
    }
}
public class UserValidation {

    @FunctionalInterface
    interface Validate {
        boolean isVal(String str);
    }

    public boolean valOp(String str, Validate val){
        return val.isVal(str);
    }

    public static Validate isValidName = (String str) -> {
        try {
            if (!Pattern.matches("[A-Z]{1}[a-z]{2,}", str)) {
                throw new InvalidException();
            } else {
                System.out.println(str + " is a Valid name");
                return true;
            }
        } catch (InvalidException e) {
            return false;
        }
    };
    public static Validate isValidPHno = (String str) -> {
        try {
            if (Pattern.matches("^(91)\\s{1}[1-9]{1}[0-9]{9}$", str)) {
                System.out.println("PHno is Valid");
                return true;
            } else {
                throw new InvalidException();
            }
        } catch (InvalidException e) {
            return false;
        }
    };
    public static Validate isValidEmail = (String str) -> {
        try {
            if (Pattern.matches("[\\w]{1,}([.][a-zA-Z0-9]{1,})*([-][a-zA-Z0-9]{1,})*([+][a-zA-Z0-9]{1,})*[@]{1}[a-zA-Z0-9]{1,}[.]{1}[a-zA-Z]{2,}([.][a-zA-Z]{2,})?",
                    str)) {
                System.out.println("Valid Email");
                return true;
            } else {
                throw new InvalidException();
            }
        } catch (InvalidException e) {
            return false;
        }
    };
    public static Validate isValidPass = (String str) -> {
        try {
            if (Pattern.matches("(.*[A-Z].*)", str) && Pattern.matches("[\\S]{8,}", str) && Pattern.matches("(.*[0-9].*)", str)) {
                String p = "[\\W]";
                Pattern r = Pattern.compile(p);
                Matcher m = r.matcher(str);
                int count = 0;
                while (m.find()) {
                    count++;
                }
                if (count == 1) {
                    System.out.println("valid password");
                    return true;
                }
            }
            throw new InvalidException();
        } catch (InvalidException e) {
            return false;
        }
    };

    public static void main(String[] args) {
        System.out.println("Welcome to User Validation");
        Scanner sc = new Scanner(System.in);
        UserValidation user = new UserValidation();
        user.valOp("Abhinav",isValidName);

    }
}
