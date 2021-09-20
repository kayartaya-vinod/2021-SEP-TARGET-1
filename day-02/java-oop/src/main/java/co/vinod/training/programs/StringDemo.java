package co.vinod.training.programs;

public class StringDemo {
    public static void main(String[] args) {

        String n1 = "Vinod"; // a new String object with "Vinod" as value is created and stored in cache
        String n2 = "Vinod"; // since "Vinod" is in the cache, n2 refers to the same object
        String n3 = new String("Vinod");

        System.out.println("n1==n2 is " + (n1==n2));
        System.out.println("n1==n3 is " + (n1==n3));
        System.out.println("n1.equals(n3) is " + n1.equals(n3));
    }
}
