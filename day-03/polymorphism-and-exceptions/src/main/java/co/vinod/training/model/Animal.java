package co.vinod.training.model;

// Abstract can never be instantiated
// A reference of an abstract class must refer to an object a concrete subclass
public abstract class Animal {

//    abstract methods are used to enforce subclasses to provide method definitions (contracts)
    public abstract void info();

    public abstract void talk();

    public abstract String getAuthor();

}
