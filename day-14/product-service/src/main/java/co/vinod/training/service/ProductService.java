package co.vinod.training.service;

import co.vinod.training.entity.Product;

public interface ProductService {
    public Product getProductById(Integer id);
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize);
    public Iterable<Product> getDiscontinuedProducts();
    public Iterable<Product> getNotDiscontinuedProducts();
    public Iterable<Product> getProductsBetween(Double min, Double max);
}
