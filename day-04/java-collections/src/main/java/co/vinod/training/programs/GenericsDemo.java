package co.vinod.training.programs;

import co.vinod.training.entity.Circle;

public class GenericsDemo {

    public static void main(String[] args) {

        Circle<Double> c1 = new Circle<Double>();
        c1.setRadius(12.0);

        Circle<Integer> c2 = new Circle<Integer>();
        c2.setRadius(12);

        Circle<String> c3;
        c3= new Circle<>();
        c3.setRadius("12");

    }
}
