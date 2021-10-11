package by.academy.it.controller;

public class UserFormValidator {
    public static boolean validate(String name, String phone, String email){
        return name.trim().length() != 0 && phone.trim().length() != 0 && email.trim().length() != 0;
    }
}
