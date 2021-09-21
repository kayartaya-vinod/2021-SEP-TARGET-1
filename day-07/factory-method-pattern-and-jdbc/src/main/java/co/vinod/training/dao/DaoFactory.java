package co.vinod.training.dao;

import java.util.ResourceBundle;

public final class DaoFactory {
    // do not let anyone instantiate this class
    private DaoFactory() {
    }

    private static ProductDao dao = null;

    public static ProductDao getProductDao() throws DaoException {
        if (dao != null) return dao;

        ResourceBundle rb = ResourceBundle.getBundle("product-dao");
        String discriminator = rb.getString("discriminator");

        switch (discriminator.toLowerCase()) {
            case "arraylist":
                dao = new ArrayListProductDao();
                break;
            case "jdbc":
                dao= new JdbcProductDao(); break;
            case "hashmap":
                // dao= new HashMapProductDao(); break;
            case "csv":
                // dao= new CsvProductDao(); break;
            case "jpa":
                // dao= new JpaProductDao(); break;
            default:
                throw new DaoException("Request for unknown type of implementation for ProductDao");
        }
        return dao;
    }
}
