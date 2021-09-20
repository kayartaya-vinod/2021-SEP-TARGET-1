package co.vinod.training.programs;

import co.vinod.training.model.Person;

public class ConstructorDemo {

    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person("Arun", 47, 5.6);

        p1.setName("Vinod");
        p1.setAge(48);
        p1.setHeight(5.8);

        System.out.println(p1);
        System.out.println(p2);

    }
}
