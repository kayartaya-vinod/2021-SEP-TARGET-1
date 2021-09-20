package co.vinod.training.programs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("name", "Vinod");
        props.setProperty("city", "Bangalore");
        props.setProperty("phone", "9731424784");
        props.setProperty("email", "vinod@vinod.co");


        try (FileWriter file = new FileWriter("vinod.properties");) {
            props.store(file, "Created on 17th Sep 2021");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Stored!");
        System.out.println(props);
    }
}
