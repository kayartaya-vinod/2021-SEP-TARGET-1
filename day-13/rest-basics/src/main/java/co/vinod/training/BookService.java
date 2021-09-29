package co.vinod.training;

import co.vinod.training.entity.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

// Spring boot automatically creates an object of this class (because of @Service)
// and keeps it in the spring container
@Service
public class BookService {
    Map<Integer, Book> books = new LinkedHashMap<>();

    public BookService(){
        Book b1;
        b1 = new Book(12, "Let us C", Arrays.asList("Yashwant Kanitkar"), 299.0, 150);
        books.put(b1.getId(), b1);
        b1 = new Book(98, "Java unleashed", Arrays.asList("John Doe", "Jane Doe"), 799.0, 500);
        books.put(b1.getId(), b1);
        b1 = new Book(56, "Spring boot in easy steps", Arrays.asList("Vinod"), 459.0, 240);
        books.put(b1.getId(), b1);

    }

    public Book getBookById(Integer id){
        return books.get(id);
    }

    public Iterable<Book> getAllBooks(){
        return books.values();
    }
}
