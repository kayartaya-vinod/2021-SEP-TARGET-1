package co.vinod.training.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        printListDetails(nums);
        nums.add(12);
        nums.add(22);
        nums.add(348);
        printListDetails(nums);

        nums.add(0, 23);
        nums.add(2, 100);
        printListDetails(nums);

        nums.set(nums.indexOf(22), 33);
        printListDetails(nums);

        Vector<Integer> v = new Vector<>();
        System.out.println("v.capacity() = " + v.capacity());
        for(int i=0; i<81; i++){
            v.add(i);
        }
        System.out.println("v.capacity() = " + v.capacity());

    }

    static void printListDetails(List<? extends Object> data){
        System.out.println("data.size() = " + data.size());
        System.out.println("content = " + data);
        System.out.println();
    }
}
