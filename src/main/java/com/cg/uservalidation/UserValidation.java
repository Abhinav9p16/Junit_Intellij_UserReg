package com.cg.uservalidation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    public static boolean isValidName(String name) {
        // Regex to check valid username
        String regex = "^[A-Z][a-zA-Z]{2,}$";

        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to User Validation");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First name ");
        String fname = sc.nextLine();
        System.out.println(fname + ":" + isValidName(fname));
        System.out.println("Enter Last name ");
        String lname = sc.nextLine();
        System.out.println(lname + ":" + isValidName(lname));
    }
}
