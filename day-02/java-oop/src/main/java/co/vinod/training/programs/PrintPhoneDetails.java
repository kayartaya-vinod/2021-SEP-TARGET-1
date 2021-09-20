package co.vinod.training.programs;

import co.vinod.training.model.MobilePhone;

public class PrintPhoneDetails {

    public static void main(String[] args) {

        MobilePhone mp1 = new MobilePhone();

        mp1.setName("Samsung");
        mp1.setPrice(25600.0);
        mp1.setDimension("6\"x4.5\"");
        mp1.setBatteryCapacity("12000 amph");

        System.out.println(mp1);
    }
}
