package co.vinod.training.programs;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        Map<String, String> friends = new HashMap<>();
        friends.put("Vinay", "Hassan");
        friends.put("Shyam", "Shivamogga");
        friends.put("Nived", "Nagpur");
        friends.put("Nimesh", "Newzealand");
        friends.put("Naveen", "Bangalore");
        friends.put("Arun", "Bangalore");
        friends.put("Nived", "Hyderabad");


        System.out.println(friends);
        String name = "Naresh";
        if(friends.containsKey(name)) {
            System.out.println(name + " lives in " + friends.get(name));
        }
        else {
            System.out.println(name + " is not in your friend list");
        }

        Set<String> keys = friends.keySet();
        System.out.println("keys are");
        for(String k: keys){
            System.out.println(k);
        }
        System.out.println();

        Collection<String> values = friends.values();
        System.out.println("Values are...");
        for(String v: values){
            System.out.println(v);
        }
        System.out.println();

        Set<Map.Entry<String, String>> entries = friends.entrySet();
        System.out.println("Entries are...");
        for(Map.Entry<String, String> e: entries){
            System.out.println(e.getKey() + " --> " + e.getValue());
        }
    }
}
