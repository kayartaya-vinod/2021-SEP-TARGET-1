package com.kvinod.training.programs;

public class HelloWorld {

    // this is a method/function definition
    static void say_hello(){
        System.out.println("Hello, world!");
    }

    static void welcome(){
        System.out.println("Weclome to Java programming");
    }

    public static void main(String[] args) {
        System.out.println("Start of main");
        say_hello(); // this is a call to the method/function (invoking)
        welcome();
        welcome();
        welcome();
        say_hello();
        System.out.println("End of main");
    }

}
