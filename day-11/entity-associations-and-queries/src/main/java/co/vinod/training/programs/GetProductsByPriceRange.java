package co.vinod.training.programs;

import co.vinod.training.entity.Product;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetProductsByPriceRange {
    public static void main(String[] args) {
        Double min = 50.0;
        Double max = 500.0;

        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();
            String jpql = "from Product where unitPrice between ?0 and :MAX_PRICE order by unitPrice desc";
            TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
            qry.setParameter(0, min);
            qry.setParameter("MAX_PRICE", max);
            List<Product> list = qry.getResultList();

            list.forEach(p -> log.debug("Name = {}, Price = {}", p.getProductName(), p.getUnitPrice()));

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
