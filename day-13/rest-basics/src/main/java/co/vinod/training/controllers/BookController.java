package co.vinod.training.controllers;

import co.vinod.training.BookService;
import co.vinod.training.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    // dependency
    // Spring container automatically injects a suitable object of (1) either with matching name
    // or (2) with matching datatype
    @Autowired
    BookService bookService;

    @GetMapping
    public Iterable<Book> handleGetBooks(){
        return bookService.getAllBooks();
    }

    // http://localhost:8080/api/books/12
    @GetMapping("/{id}")
    public Book handleGetBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

}
