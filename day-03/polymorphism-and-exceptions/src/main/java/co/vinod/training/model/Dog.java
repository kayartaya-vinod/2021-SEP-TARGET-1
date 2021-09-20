package co.vinod.training.model;

public class Dog extends Animal{
    @Override
    public void info() {
        System.out.println("Dog class by Vinod");
    }

    @Override
    public void talk() {
        System.out.println("Dog says bow bow...");
    }

    @Override
    public String getAuthor() {
        return "Kumar";
    }

    public void wagTail(){
        System.out.println("Dog is friendly and wagging its tail...");
    }

}
