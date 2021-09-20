package co.vinod.training.entity;

@FunctionalInterface
public interface Hello {
    public void sayHello(String name);
    default public void sayHello(String name, String city){
        System.out.printf("Hello %s, how's weather in %s?\n", name, city);
    }
}
