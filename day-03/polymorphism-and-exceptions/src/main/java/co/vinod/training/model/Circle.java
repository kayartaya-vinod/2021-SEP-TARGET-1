package co.vinod.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Circle implements Shape{

    private double radius;

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public String getTypeName() {
        return "Circle";
    }
}
