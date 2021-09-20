package co.vinod.training.programs;

import co.vinod.training.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoreStreamsDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Vinod", 48, 5.8, "Bangalore"));
        people.add(new Person("Arunima", 20, 5.5, "Mysore"));
        people.add(new Person("Naveen", 48, 5.9, "Mangalore"));
        people.add(new Person("Arun", 48, 5.8, "Bangalore"));
        people.add(new Person("Ramesh", 44, 5.8, "Delhi"));
        people.add(new Person("Mahesh", 52, 5.7, "Bangalore"));
        people.add(new Person("Arunima", 20, 5.5, "Kolkata"));
        people.add(new Person("Arunima", 18, 5.3, "Hyderabad"));

        // list of names , age >=40, city = bangalore

        List<String> names = people.stream()
                .filter(p -> p.getAge() >= 40)
                .filter(p -> p.getCity().equals("Bangalore"))
                .map(p -> p.getName())
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
