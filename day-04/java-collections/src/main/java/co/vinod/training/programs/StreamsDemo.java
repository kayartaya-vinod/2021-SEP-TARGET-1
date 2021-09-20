package co.vinod.training.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vinod", "Shyam", "Arun", "Anil", "Kiran", "Kishore");
        System.out.println(names.getClass().getName());

        // jdk 1.5 +
        for(String name: names){
            System.out.println(name);
        }

        System.out.println();

        // jdk 1.8 +
        names.stream()
                .filter(name->name.startsWith("A"))
                .map(name->name.toUpperCase())
                .forEach(System.out::println);
    }
}
