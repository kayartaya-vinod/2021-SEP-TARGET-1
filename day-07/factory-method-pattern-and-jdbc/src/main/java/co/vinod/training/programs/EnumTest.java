package co.vinod.training.programs;

import co.vinod.training.entity.Gender;

public class EnumTest {

    public static void main(String[] args) {

        Gender g = Gender.valueOf("MALE");
        System.out.println("g is " + g);

        // Gender.valueOf(rs.getString("gender"))
    }
}
