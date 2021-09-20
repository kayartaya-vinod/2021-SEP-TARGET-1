package co.vinod.training.programs;

import co.vinod.training.model.Circle;

public class ProcessCircles {

    public static void main(String[] args) {

        Circle c1 = new Circle();
        c1.radius = 2.5;

        Circle c2 = new Circle();
        c2.radius=3.5;

        c1.printArea();
        c2.printArea();

    }
}
