package co.vinod.training.model;

public class Circle {
    public double radius;
    public static double pi = 3.1416;

    // when this function is invoked using a reference, the members of the object referred by the reference
    // will be made accessible inside this function. For example, if this method is called using c1
    // (like c1.printArea()), then radius inside the function is same as c1.radius. If a static variable is
    // accessed inside this function (like pi), it is same as Circle.pi
    public void printArea() {
        double area = pi * radius * radius;
        System.out.printf("Area of circle with radius %.2f units is %.2f sq.units\n", radius, area);
    }
}
