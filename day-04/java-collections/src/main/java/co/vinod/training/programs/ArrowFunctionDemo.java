package co.vinod.training.programs;

import co.vinod.training.entity.Hello;

public class ArrowFunctionDemo {

    static void greet(Hello h, String name) {
        h.sayHello(name);
        h.sayHello(name, "World");
    }

    // pure functions take parameter work/return based on the input
    // have no dependencies on  members of the class, and hence must be marked as static
    static void printInUpper(String str){
        System.out.println(str.toUpperCase());
    }

    public static void main(String[] args) {
        greet((name) -> System.out.println(name), "Vinod");
        greet(System.out::println, "Shyam");
        greet(ArrowFunctionDemo::printInUpper, "Shyam");
    }
}
