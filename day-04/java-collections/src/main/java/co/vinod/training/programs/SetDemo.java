package co.vinod.training.programs;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();
        names.add("Vinod");
        names.add("Shyam");
        names.add(new String("Vinod"));
        names.add("Naveen");
        names.add("Ramesh");
        names.add(new String("Vinod"));
        names.add("Arun");
        names.add("Nimesh");
        names.add("Anil");

        System.out.println("Size = " + names.size());
        System.out.println("Content = " + names);

    }
}
