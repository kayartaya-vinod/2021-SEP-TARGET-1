package co.vinod.training.dao;

import co.vinod.training.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ArrayListProductDao implements ProductDao{

    public static final String METHOD_NOT_IMPLEMENTED_YET = "Method not implemented yet!";
    private List<Product> list = new ArrayList<>();

    public ArrayListProductDao(){
        list.add(new Product(12, "Apple magic mouse", 8000.0));
        list.add(new Product(87, "Dell mouse", 6500.));
        list.add(new Product(19, "Apple pencil", 8500.0));
        list.add(new Product(78, "Logitech Keyboard", 700.0));
    }

    @Override
    public void addProduct(Product product) throws DaoException {
        if(product==null){
            throw new DaoException("Cannot add a null product");
        }
        if(product.getId()==null || product.getId()<=0){
            throw new DaoException("Id cannot be null or 0 or negative");
        }
        // do more validations here
        list.add(product);
    }

    @Override
    public Product getById(Integer id) throws DaoException {
        throw new DaoException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        throw new DaoException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public List<Product> getAll() throws DaoException {
        return this.list;
    }

    @Override
    public List<Product> getByPriceRange(Double min, Double max) throws DaoException {
        throw new DaoException(METHOD_NOT_IMPLEMENTED_YET);
    }
}
