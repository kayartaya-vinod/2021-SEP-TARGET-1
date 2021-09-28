package co.vinod.training.programs;

import co.vinod.training.entity.Product;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class GetOneProductWithCategory {
    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = JpaUtil.createEntityManager();
            Product p = em.find(Product.class, 1);
            log.debug("Name = {}", p.getProductName());
            log.debug("Category = {}", p.getCategory().getCategoryName());
            log.debug("Description = {}", p.getCategory().getDescription());
            FileOutputStream file = new FileOutputStream(
                    p.getCategory().getCategoryName() + "_" + System.currentTimeMillis() + ".png");
            file.write(p.getCategory().getPicture());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
