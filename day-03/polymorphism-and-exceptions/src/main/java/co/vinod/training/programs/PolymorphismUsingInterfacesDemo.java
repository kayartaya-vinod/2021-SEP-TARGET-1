package co.vinod.training.programs;

import co.vinod.training.model.Circle;
import co.vinod.training.model.Shape;
import co.vinod.training.model.Triangle;

public class PolymorphismUsingInterfacesDemo {
    public static void main(String[] args) {

        Circle c1 = new Circle(12.34);
        Triangle t1 = new Triangle(12, 34);

        printInfoAboutShape(c1);
        printInfoAboutShape(t1);
    }

    static void printInfoAboutShape(Shape shape){
        // an object of Shape cannot be created, but can be realised using an object
        // of a class that implements the interface

        System.out.println("Area of " + shape.getTypeName() + " is " + shape.getArea() + " sq.units.");
    }
}
