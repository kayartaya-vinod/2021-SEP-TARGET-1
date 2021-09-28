package co.vinod.training.programs;

import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetOutOfStockProductNames {
    public static void main(String[] args) {
        String jpql = "select productName from Product where unitsInStock=0";
        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();
            TypedQuery<String> qry = em.createQuery(jpql, String.class);
            List<String> list = qry.getResultList();

            list.forEach(log::debug);

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
