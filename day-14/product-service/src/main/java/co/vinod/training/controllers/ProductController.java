package co.vinod.training.controllers;

import co.vinod.training.entity.ApiError;
import co.vinod.training.entity.Product;
import co.vinod.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController // instructs spring to create and load an instance of this class into the spring container
@RequestMapping("/api/products") // instructs handler-mapping to make a note of all handler methods
public class ProductController {

    // dependency
    @Autowired // instruct spring to find a suitable object of type ProductService and assign the same
            ProductService service;

    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Object> handleGetProductById(@PathVariable Integer id) {
        Product p = service.getProductById(id);
        if (p != null) {
            // status 200
            return ResponseEntity.ok(p);
        } else {
            // status 404
//            return ResponseEntity.notFound().build();
            ApiError err = new ApiError(HttpStatus.NOT_FOUND, new Date(), "Product not found for id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }

    @GetMapping(path = "/{id}", produces = "text/plain")
    public String handleGetProductByIdAsString(@PathVariable Integer id) {
        return service.getProductById(id).toString();
    }

    @GetMapping(produces = {"application/json"})
    public Iterable<Product> handleGetAllProducts(
            @RequestParam(name = "_page", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "_limit", required = false, defaultValue = "10") Integer pageSize) {

        return service.getAllProducts(pageNum, pageSize);
    }

    // api/products?discontinued=true
    @GetMapping(path = "/filter", params = {"discontinued"})
    public Iterable<Product> handleGetDiscontinuedProducts(@RequestParam Boolean discontinued) {
        return discontinued ? service.getDiscontinuedProducts() : service.getNotDiscontinuedProducts();
    }

    @GetMapping(path = "/filter", params = {"min", "max"})
    public Iterable<Product> handleGetProductsInPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return service.getProductsBetween(min, max);
    }
}
