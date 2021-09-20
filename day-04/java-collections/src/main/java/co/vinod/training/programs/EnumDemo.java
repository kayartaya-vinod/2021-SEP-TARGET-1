package co.vinod.training.programs;

import co.vinod.training.entity.Customer;
import co.vinod.training.entity.Gender;

public class EnumDemo {
    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.setName("Vinod");
        c1.setGender(Gender.MALE);

        if(c1.getGender()==Gender.MALE){
            System.out.println("Hello Mr." + c1.getName());
        }
        else {
            System.out.println("Hello, Ms." + c1.getName());
        }

        System.out.println(c1);
    }
}
