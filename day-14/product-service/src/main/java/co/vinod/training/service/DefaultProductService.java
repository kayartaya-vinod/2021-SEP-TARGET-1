package co.vinod.training.service;

import co.vinod.training.dao.ProductDao;
import co.vinod.training.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service // instructs spring to create and load an instance of this class into the spring container
public class DefaultProductService implements ProductService {

    // depends on ProductDao (dependency)
    @Autowired
    private ProductDao dao;

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
    public Iterable<Product> getAllProducts(Integer pageNum,
                                            Integer pageSize) {
        PageRequest p = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> result = dao.findAll(p);

        if(result.hasContent()){
            return result.getContent();
        }
        else {
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
