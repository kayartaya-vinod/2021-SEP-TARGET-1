package co.vinod.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle implements Shape{

    private double base;
    private double height;

    @Override
    public double getArea() {
        return .5 * base * height;
    }

    @Override
    public String getTypeName() {
        return "Triangle";
    }
}
