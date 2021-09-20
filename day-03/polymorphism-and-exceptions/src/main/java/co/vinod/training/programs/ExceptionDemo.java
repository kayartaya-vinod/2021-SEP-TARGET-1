package co.vinod.training.programs;

import java.io.FileReader;

public class ExceptionDemo {

    public static void main(String[] args) {
        
        try{
            String s1 = args[0];
            String s2 = args[1];

            int num = Integer.parseInt(s1);
            int den = Integer.parseInt(s2);

            int quotient = num / den;

            System.out.printf("Quotient of %d divided by %d is %d\n", num, den, quotient);
        }
        catch(Exception ex){
            System.out.printf("There was an error of type %s with a message \"%s\"\n",
                    ex.getClass().getName(),
                    ex.getMessage());
        }

        System.out.println("This is the end of the program.");
    }
}
