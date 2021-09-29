package co.vinod.training.programs;

import co.vinod.training.entity.LineItem;
import co.vinod.training.utils.JpaUtil;

import javax.persistence.EntityManager;

public class GetOneLineItem {
    public static void main(String[] args) {
        Integer orderId = 10249;
        Integer productId = 51;

        EntityManager em = JpaUtil.createEntityManager();
        LineItem li = em.find(LineItem.class, new LineItem(orderId, productId));

        System.out.println(li);
    }
}
