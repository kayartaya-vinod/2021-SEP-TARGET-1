package com.kvinod.training.programs;

import com.kvinod.training.util.KeyboardUtil;

public class AcceptFromKeyboard {

    public static void main(String[] args) {

        String name = KeyboardUtil.getString("Enter your name: ");
        int age = KeyboardUtil.getInt("Enter your age: ");
        String city = KeyboardUtil.getString("Enter your city: ");

        System.out.printf("%s from %s is %d years old.\n", name, city, age);


    }
}
