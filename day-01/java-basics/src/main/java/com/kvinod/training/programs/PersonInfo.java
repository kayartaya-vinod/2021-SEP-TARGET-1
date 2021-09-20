package com.kvinod.training.programs;


public class PersonInfo {

    public static void main(String[] args) {

        int age = 48;
        double height = 5.8;
        double weight = 81.9;
        boolean isMarried = false;

        String name = "Vinod Kumar Sharma";

        System.out.println("Name    = " + name);
        System.out.println("Age     = " + age + " years");
        System.out.println("Height  = " + height + " ft");
        System.out.println("Weight  = " + weight + " kgs");

        if (isMarried) {
            System.out.println(name + " is married");
        } else {
            System.out.println(name + " is not married");
        }

        if (height < 5.0) {
            System.out.println(name + " is short");
        } else if (height >= 6.0) {
            System.out.println(name + " is tall");
        } else {
            System.out.println(name + " has an average height!");
        }
    }

}
