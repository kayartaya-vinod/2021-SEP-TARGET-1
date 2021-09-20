package co.vinod.training.model;

public class Person { // by default "extends Object" is implied
    private String name;
    private int age; // allowed values are -2^31 to +(2^31)-1
    private double height;

    // Default or no-args constructor.
    // If there are no constructors in this class, the compiler would have given this by default.
    // This is a good practice; and must be added unless you really don't want.
    public Person() {
    }

    // overloaded/parameterized constructor
    public Person(String name, int age, double height) {
        setName(name);
        setAge(age);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0 && age<=150) {
            this.age = age;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height>=0 && height<=8){
            this.height = height;
        }
    }

    // write your own toString (override) to textually represent an object of Person class
    @Override
    public String toString() {
        return "Object of co.vinod.training.model.Person with values {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public void print() {
        System.out.println("Name   = " + name);
        System.out.println("Age    = " + age + " years");
        System.out.println("Height = " + height + " ft.");
        System.out.println();
    }
}
