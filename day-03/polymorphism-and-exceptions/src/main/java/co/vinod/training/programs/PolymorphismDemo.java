package co.vinod.training.programs;

import co.vinod.training.model.Animal;
import co.vinod.training.model.Cat;
import co.vinod.training.model.Dog;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal a1; // reference of Animal

        Cat c1 = new Cat();
        Dog d1 = new Dog();

        a1 = c1; // up-casting; happens implicitly
        printAbout(a1);
        a1 = d1;
        printAbout(a1);
    }

    static void printAbout(Animal a1){
        a1.info(); // if a subclass of Animal has overridden this method, then it is impossible to call from Animal class here
        a1.talk();
        System.out.println("Authored by " + a1.getAuthor());
        if(a1 instanceof Cat){
            ((Cat)a1).phurr();
        }
        else if(a1 instanceof Dog) {
            ((Dog)a1).wagTail();
        }
    }
}
