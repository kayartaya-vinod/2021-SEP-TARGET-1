package co.vinod.training.dao;

import co.vinod.training.entity.Product;

import java.util.List;

public interface ProductDao {
    // CRUD operations
    public void addProduct(Product product) throws DaoException;
    public Product getById(Integer id) throws DaoException;
    public void updateProduct(Product product) throws DaoException;

    // QUERIES
    public List<Product> getAll() throws DaoException;
    public List<Product> getByPriceRange(Double min, Double max) throws DaoException;
}
