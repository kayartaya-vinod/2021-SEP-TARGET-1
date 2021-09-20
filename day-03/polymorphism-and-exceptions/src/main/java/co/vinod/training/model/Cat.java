package co.vinod.training.model;

public class Cat extends Animal {

    // this method now hides the visibility of info() defined in Animal class
    @Override
    public void info() {
        System.out.println("Cat class created by Vinod");
    }

    @Override
    public void talk() {
        System.out.println("Cat says meow...");
    }

    @Override
    public String getAuthor() {
        return "Vinod";
    }

    public void phurr(){
        System.out.println("Cat is in a lazy mood and phurring...");
    }

}
