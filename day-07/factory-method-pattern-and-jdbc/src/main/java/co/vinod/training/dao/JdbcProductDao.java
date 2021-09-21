package co.vinod.training.dao;

import co.vinod.training.entity.Product;

import java.util.List;

public class JdbcProductDao implements ProductDao {
    @Override
    public void addProduct(Product product) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public Product getById(Integer id) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public List<Product> getAll() throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }

    @Override
    public List<Product> getByPriceRange(Double min, Double max) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }
}
