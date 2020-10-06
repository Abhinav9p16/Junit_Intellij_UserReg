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
    public static boolean isValidPHno(String num) {
        // Regex to check valid pin code of India.
        String regex = "^(91)\\s{1}[1-9]{1}[0-9]{9}$";

        Pattern p = Pattern.compile(regex);
        if (num == null) {
            return false;
        }
        Matcher m = p.matcher(num);
        return m.matches();
    }
    public static boolean isValidEmail(String email) {
        // Regex to check valid email
        String regex = "^[A-Za-z0-9]{1}[A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+){0,1}(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public static boolean isValidPass(String pass){
        String regex =   "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?!.*[<>`])"+ "(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)" + ".{8,}$";
        Pattern p = Pattern.compile(regex);
        if (pass == null) {
            return false;
        }
        Matcher m = p.matcher(pass);
        return m.matches();
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
        System.out.println(userValidation.isValidName(sc.nextLine()));
        System.out.println("Enter the EMAIL");
        System.out.println(userValidation.isValidEmail(sc.nextLine()));
        System.out.println("Enter Password ");
        System.out.println(userValidation.isValidPass(sc.nextLine()));
        System.out.println(userValidation.happyOrSad(sc.nextLine()));
    }
}
