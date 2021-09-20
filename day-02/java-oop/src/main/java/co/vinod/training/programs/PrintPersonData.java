package co.vinod.training.programs;

import co.vinod.training.model.Person;

public class PrintPersonData {
    public static void main(String[] args) {
        Person p1;

        p1 = new Person();
        p1.setName("Vinod");
        p1.setAge(4800);
        p1.setHeight(5.8);

        p1.print();

        System.out.println(p1);
        System.out.println(p1.toString());

    }
}
