package co.vinod.training.programs;

// every class outside this package with an exception to java.lang must be imported

import co.vinod.training.model.Book;

public class PrintBookDetails {

    public static void main(String[] args) {
        Book b1; // a reference; occupies 8 bytes in stack
        // at this time, the class Book is not loaded to JVM yet

        b1 = new Book(); // is an object in heap; occupies 36 bytes in heap.
        // at this time, if the class Book is not loaded yet, it will be searched and loaded to JVM

        System.out.println("b1 is " + b1); // b1.toString()
        System.out.println("Title is " + b1.title);
        b1.title = "Let us C";
        b1.price = 399.0;
        b1.title = "Let us J";
        System.gc();
    }
}
