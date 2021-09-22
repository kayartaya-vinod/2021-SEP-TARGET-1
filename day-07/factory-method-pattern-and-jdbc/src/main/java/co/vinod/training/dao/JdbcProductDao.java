package co.vinod.training.dao;

import co.vinod.training.entity.Product;
import co.vinod.training.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {
    @Override
    public void addProduct(Product product) throws DaoException {
        String sql = "insert into products values (?, ?, ?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // first visit to db server for compiling sql command
        ) {
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.execute();
        }
        catch (Exception e) {
            throw new DaoException(e); // wrapping "e" with a new instance of DaoException
        }
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
        List<Product> list = new ArrayList<>();
        String sql = "select * from products";
        try (
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                // convert data from result-set to a product object
                Product p = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
                list.add(p);
            }
        } catch (Exception e) {
            throw new DaoException(e); // wrapping "e" with a new instance of DaoException
        }
        return list;
    }

    @Override
    public List<Product> getByPriceRange(Double min, Double max) throws DaoException {
        throw new DaoException("Method not implemented using JDBC yet!");
    }
}
