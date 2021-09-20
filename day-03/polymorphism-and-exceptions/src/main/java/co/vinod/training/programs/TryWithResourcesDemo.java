package co.vinod.training.programs;

import co.vinod.training.model.DummyResource;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryWithResourcesDemo {

    public static void main(String[] args) {

        String filename = "src/main/java/co/vinod/training/model/Circle.java";

        try (
                DummyResource dr = new DummyResource();
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            dr.doStuff();
//            int n = 12/0; // uncomment this to check what happens if there is an exception
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } // both reader and in are closed here (reader.close() in.close() are automatically called here)
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
