package co.vinod.training.dao;

import co.vinod.training.entity.Product;

import java.util.List;

public class JpaProductDao implements ProductDao{
    @Override
    public void addProduct(Product product) throws DaoException {
//        em.persist(product);
    }

    @Override
    public Product getById(Integer id) throws DaoException {
//        return em.find(Product.class, id);
        return null;
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
//        em.merge(product);
    }

    @Override
    public List<Product> getAll() throws DaoException {
        return null;
    }

    @Override
    public List<Product> getByPriceRange(Double min, Double max) throws DaoException {
        return null;
    }
}
