package co.vinod.training.programs;

import co.vinod.training.entity.Customer;
import co.vinod.training.entity.LineItem;
import co.vinod.training.entity.Order;
import co.vinod.training.utils.DateUtil;
import co.vinod.training.utils.JpaUtil;
import co.vinod.training.utils.KeyboardUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GetOrderDetails {
    public static void main(String[] args) {
        Integer orderId = KeyboardUtil.getInt("Enter order id to get details for: ");
        EntityManager em = JpaUtil.createEntityManager();
        Order order = em.find(Order.class, orderId);

        printOrderInformation(order);
        line();
        printCustomerDetails(order.getCustomer());
        line();
        // printShipperDetails(order.getShipper());
        // printEmployeeDetails(order.getEmployee());
        printLineItems(order.getLineItems());

        em.close();
    }

    static void printLineItems(List<LineItem> lineItems) {
        System.out.println("Products in this order are:");
        line();
        System.out.printf("%-45s %10s %10s %10s %10s%n",
                "Product name", "Unit price", "Quantity", "Discount", "Amount");
        line();
        double total = 0;
        for(LineItem li: lineItems){
            System.out.printf("%-45s %10s %10s %10s %10.2f%n",
                    li.getProduct().getProductName() + " (" + li.getProduct().getCategory().getCategoryName() + ")",
                    li.getUnitPrice(),
                    li.getQuantity(),
                    li.getDiscount()*100 + "%",
                    (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity()));
            total += (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity());
        }
        line();
        System.out.printf("%78s %10.2f%n", "Total", total);
        line();
    }

    static void printCustomerDetails(Customer customer) {
        System.out.println("Company name                  : " + customer.getCompanyName());
        System.out.println("Contact person                : " + customer.getContactName());
        System.out.println("Job title                     : " + customer.getContactTitle());
        System.out.println("Address                       : " + customer.getAddress());
        System.out.println("                                " + customer.getCity());
        System.out.println("                                " + customer.getRegion());
        System.out.println("                                " + customer.getCountry() + " " + customer.getPostalCode());

    }

    static void printOrderInformation(Order order) {
        System.out.println("Order id                      : " + order.getOrderId());
        System.out.println("Order date                    : " + DateUtil.toString(order.getOrderDate()));
        System.out.println("Required date                 : " + DateUtil.toString(order.getRequiredDate()));
        if (order.getShippedDate() != null) {
            System.out.println("Shipped date                  : " + DateUtil.toString(order.getShippedDate()));
        }
        System.out.println("Shipped to                    : " + order.getShipName());
        System.out.println("                                " + order.getShipAddress());
        System.out.println("                                " + order.getShipCity());
        if (order.getShipRegion() != null) {
            System.out.println("                                " + order.getShipRegion());
        }
        System.out.println("                                " + order.getShipCountry() + " " + order.getShipPostalCode());

    }

    static void line() {
        for (int i = 0; i < 95; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}
