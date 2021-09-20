package co.vinod.training.programs;

import co.vinod.training.utils.KeyboardUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) {

        String dob = KeyboardUtil.getString("Enter your birth date (dd/mm/yyyy): ");
        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sdf.setLenient(false);
            dt = sdf.parse(dob);
            System.out.println(dt);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please retry!");
        }

    }
}
