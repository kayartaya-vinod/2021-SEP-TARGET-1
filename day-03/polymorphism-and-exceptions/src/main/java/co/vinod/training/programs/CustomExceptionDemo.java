package co.vinod.training.programs;

import co.vinod.training.model.Employee;
import co.vinod.training.model.EmptyOrNullNameException;
import co.vinod.training.model.InvalidIdException;

public class CustomExceptionDemo {
    public static void main(String[] args) throws EmptyOrNullNameException, InvalidIdException {

        Employee e1;

        e1 = new Employee();
        e1.setName("");
        e1.setId(-7788);
        e1.setSalary(-4500.0);


        System.out.println(e1);
    }
}
