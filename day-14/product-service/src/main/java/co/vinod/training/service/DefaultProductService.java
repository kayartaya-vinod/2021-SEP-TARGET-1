package co.vinod.training.service;

import co.vinod.training.dao.ProductDao;
import co.vinod.training.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Primary
@Slf4j
@Service // instructs spring to create and load an instance of this class into the spring container
public class DefaultProductService implements ProductService {

    // depends on ProductDao (dependency)
    @Autowired
    private ProductDao dao;

    @Override
    public Product addNewProduct(Product product) {
        // inorder to ensure that save() does INSERT, we have to set product's id to NULL
        product.setProductId(null);
        // do all validations about product's members before saving.
        return dao.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> op = dao.findById(id);
        Product p = null;
        if (op.isPresent()) {
            p = op.get();
        }
        log.debug("Product for {} is {}", id, p);
        return p;
    }

    @Override
    public Product updateProduct(Product product) {
        if (product.getProductId() == null) {
            // throw a custom exception instead of RuntimeException
            throw new RuntimeException("Product must have id for updating");
        }
        if (!dao.existsById(product.getProductId())) {
            throw new RuntimeException("Product has invalid id. Couldn't update.");
        }
        // do all validations about product's members before saving.
        return dao.save(product);
    }

    @Override
    public Product deleteProduct(Integer id) {
        Optional<Product> op = dao.findById(id);
        if (!op.isPresent()) {
            throw new RuntimeException("Product has invalid id. Couldn't delete.");
        }

        // hard delete
        // dao.deleteById(id);
        // return op.get();

        // soft delete
        Product p = op.get();
        p.setDiscontinued(1);
        return dao.save(p);
    }

    @Override
    public Iterable<Product> getAllProducts(Integer pageNum,
                                            Integer pageSize) {
        PageRequest p = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> result = dao.findAll(p);

        if (result.hasContent()) {
            return result.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Iterable<Product> getDiscontinuedProducts() {
        return dao.findByDiscontinued(1);
    }

    @Override
    public Iterable<Product> getNotDiscontinuedProducts() {
        return dao.findByDiscontinued(0);
    }

    @Override
    public Iterable<Product> getProductsBetween(Double min, Double max) {
        return dao.findProductsByPriceRange(min, max);
    }


}
