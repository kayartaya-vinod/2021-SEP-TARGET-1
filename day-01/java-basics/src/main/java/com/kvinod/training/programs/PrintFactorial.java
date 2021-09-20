package com.kvinod.training.programs;

public class PrintFactorial {

    public static void main(String[] args) {

        int num = 5;
        long fact = 1;


        while (num > 1) {
            fact *= num--;
        }

        System.out.println("Factorial is " + fact);

    }
}
