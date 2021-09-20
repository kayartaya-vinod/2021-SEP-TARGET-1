package co.vinod.training.entity;

public class Circle<T> {

    private T radius;

    public void setRadius(T radius) {
        this.radius = radius;
    }

    public T getRadius() {
        return radius;
    }

}
