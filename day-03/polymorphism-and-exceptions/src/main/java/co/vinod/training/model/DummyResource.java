package co.vinod.training.model;

import java.io.Closeable;
import java.io.IOException;

public class DummyResource implements Closeable {
    public DummyResource(){
        System.out.println("DummyResource instantiated!");
    }
    public void doStuff(){
        System.out.println("DummyResource doing stuff...");
    }
    @Override
    public void close() throws IOException {
        System.out.println("Closing the dummy resource...");
    }
}
