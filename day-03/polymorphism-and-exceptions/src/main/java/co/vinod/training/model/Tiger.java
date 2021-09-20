package co.vinod.training.model;

public  class Tiger extends Animal{
    @Override
    public void info() {
        System.out.println("Tiger class by Vinod");
    }

    @Override
    public void talk() {
        System.out.println("Tiger is saying grrr...");
    }

    @Override
    public String getAuthor() {
        return "Vinod";
    }
}
