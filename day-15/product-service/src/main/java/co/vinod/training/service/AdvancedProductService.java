package co.vinod.training.service;

import co.vinod.training.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class AdvancedProductService implements ProductService{
    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Integer id) {
        return null;
    }

    @Override
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Iterable<Product> getDiscontinuedProducts() {
        return null;
    }

    @Override
    public Iterable<Product> getNotDiscontinuedProducts() {
        return null;
    }

    @Override
    public Iterable<Product> getProductsBetween(Double min, Double max) {
        return null;
    }
}
