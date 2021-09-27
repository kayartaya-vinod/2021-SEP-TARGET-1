package co.vinod.training;

public class Calculator {

    public Double add(Object... nums) {
        Double sum = 0.;

        for (Object n : nums) {
            sum += (n == null ? 0. : Double.valueOf(n.toString()));
        }

        return sum;
    }
}
