package com.cg.uservalidation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvalidDetailsException extends Exception {
    public InvalidDetailsException() {
    }
}
public class UserValidation {
    public static boolean isValidName(String name) {
        try {
            if (!Pattern.matches("[A-Z]{1}[a-z]{2,}", name)) {
                throw new InvalidDetailsException();
            } else {
                System.out.println("Valid");
                return true;
            }
        } catch (InvalidDetailsException e) {
            return false;
        }
    }
    public static boolean isValidPHno(String num) {
        try {
            if (Pattern.matches("^(91)\\s{1}[1-9]{1}[0-9]{9}$", num)) {
                System.out.println("Valid mobile phone");
                return true;
            } else {
                throw new InvalidDetailsException();
            }
        } catch (InvalidDetailsException e) {
            return false;
        }
    }
    public static boolean isValidEmail(String email) {
        try {
            if (Pattern.matches("[\\w]{1,}([.][a-zA-Z0-9]{1,})*([-][a-zA-Z0-9]{1,})*([+][a-zA-Z0-9]{1,})*[@]{1}[a-zA-Z0-9]{1,}[.]{1}[a-zA-Z]{2,}([.][a-zA-Z]{2,})?",
                    email)) {
                System.out.println("Valid Email");
                return true;
            } else {
                throw new InvalidDetailsException();
            }
        } catch (InvalidDetailsException e) {
            return false;
        }
    }
    public static boolean isValidPass(String pass){
        try {
            if (Pattern.matches("(.*[A-Z].*)", pass) && Pattern.matches("[\\S]{8,}", pass) && Pattern.matches("(.*[0-9].*)", pass)) {
                String p = "[\\W]";
                Pattern r = Pattern.compile(p);
                Matcher m = r.matcher(pass);
                int count = 0;
                while (m.find()) {
                    count++;
                }
                if (count == 1) {
                    System.out.println("valid password");
                    return true;
                }
            }
            throw new InvalidDetailsException();
        } catch (InvalidDetailsException e) {
            return false;
        }
    }
    public String happyOrSad(String message) {
        if (message.contains("sad"))
            return "sad";
        else
            return "happy";
    }
    public static void main(String[] args) {
        System.out.println("Welcome to User Validation");
        Scanner sc = new Scanner(System.in);
        UserValidation userValidation = new UserValidation();
        System.out.println("Enter First name ");
        System.out.println(userValidation.isValidName(sc.nextLine()));
        System.out.println("Enter Last name ");
        System.out.println(userValidation.isValidName(sc.nextLine()));
        System.out.println("Enter Phone number ");
        System.out.println(userValidation.isValidPHno(sc.nextLine()));
        System.out.println("Enter the EMAIL");
        System.out.println(userValidation.isValidEmail(sc.nextLine()));
        System.out.println("Enter Password ");
        System.out.println(userValidation.isValidPass(sc.nextLine()));
        System.out.println(userValidation.happyOrSad(sc.nextLine()));
    }
}
