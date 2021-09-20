package co.vinod.training.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinallyDemo {
    public static void main(String[] args) {

        FileReader reader = null;
        BufferedReader in = null;

        String filename = "pom.xml";

        try {
            reader = new FileReader(filename);
            in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
