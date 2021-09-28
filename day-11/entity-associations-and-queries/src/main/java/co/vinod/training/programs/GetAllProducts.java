package co.vinod.training.programs;

import co.vinod.training.entity.Product;
import co.vinod.training.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetAllProducts {
    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();

            // we are building a query object, that once ready, can get the list of products
            TypedQuery<Product> qry = em.createQuery("from Product", Product.class);

            List<Product> list = qry.getResultList(); // fire the SQL SELECT statement now, and get the data in List<T> format
            list.forEach(System.out::println);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
