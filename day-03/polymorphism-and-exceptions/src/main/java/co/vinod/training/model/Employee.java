package co.vinod.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;

    public void setId(int id) throws InvalidIdException {
        if(id<=0){
            throw new InvalidIdException("Invalid value for ID");
        }
        this.id = id;
    }

    public void setName(String name) throws EmptyOrNullNameException {
        if(name==null || name.trim().length()==0){
            throw new EmptyOrNullNameException("Name cannot be empty or null");
        }
        this.name = name;
    }
}
