package co.vinod.training.programs;

import java.util.Arrays;

public class MultipleCatchesDemo {

    public static void main(String[] args) {

        try{
            String s1 = args[0];
            String s2 = args[1];

            int num = Integer.parseInt(s1);
            int den = Integer.parseInt(s2);

            int quotient = num / den;

            System.out.printf("Quotient of %d divided by %d is %d\n", num, den, quotient);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.printf("Expected 2 inputs, got %d input/s.\n", args.length);
        }
        catch (NumberFormatException e){
            System.out.printf("Expected 2 integers but received %s\n", Arrays.toString(args));
        }
        catch (ArithmeticException e){
            System.out.println("Cannot divide integer by zero");
        }
        catch (Exception e){
            System.out.println("Somethwing went wrong!");
        }


        System.out.println("This is the end of the program.");
    }
}
