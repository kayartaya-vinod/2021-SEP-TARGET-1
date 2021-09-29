package co.vinod.training.programs;

import co.vinod.training.entity.Product;
import co.vinod.training.utils.JpaUtil;
import co.vinod.training.utils.KeyboardUtil;

import javax.persistence.EntityManager;

public class GetCustomerWhoOrderedProduct {
    public static void main(String[] args) {
        int productId = KeyboardUtil.getInt("Enter product id: ");
        EntityManager em = JpaUtil.createEntityManager();

        Product product = em.find(Product.class, productId);
        product.getLineItems()
                .stream()
                .map(li -> li.getOrder())
                .map(ord -> ord.getCustomer())
                .distinct()
                .map(cust -> cust.getCompanyName())
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
