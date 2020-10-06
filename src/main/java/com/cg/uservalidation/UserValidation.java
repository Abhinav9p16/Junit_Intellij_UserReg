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
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+){0,1}(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public static boolean isValidPass(String pass){
        String regex =   "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?!.*[<>`])"+ ".{8,}$";
        Pattern p = Pattern.compile(regex);
        if (pass == null) {
            return false;
        }
        Matcher m = p.matcher(pass);
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
        System.out.println("Enter Phone number ");
        String phno = sc.nextLine();
        System.out.println(phno + ":" + isValidPHno(phno));
        System.out.println("Enter the EMAIL");
        String email = sc.nextLine();
        System.out.println(email + ":" + isValidEmail(email));
        System.out.println("Enter Password ");
        String pass = sc.nextLine();
        System.out.println(pass + ":" + isValidPass(pass));

    }
}
