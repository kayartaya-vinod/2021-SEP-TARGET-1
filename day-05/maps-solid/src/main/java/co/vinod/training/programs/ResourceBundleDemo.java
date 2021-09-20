package co.vinod.training.programs;

import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleDemo {
    public static void main(String[] args) {
        // the file must be in the classpath and must have .properties as extension
        ResourceBundle rb = ResourceBundle.getBundle("shyam");
        Set<String> keys = rb.keySet();

        for(String key: keys){
            System.out.printf("%s --> %s\n", key, rb.getString(key));
        }
    }
}
