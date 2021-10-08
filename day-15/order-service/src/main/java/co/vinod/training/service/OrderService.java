package co.vinod.training.service;

import co.vinod.training.dao.OrderDao;
import co.vinod.training.entity.Customer;
import co.vinod.training.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderDao dao;

    @Value("${microservices.url.customer-service}")
    private String customerServiceUrl;


    @Value("${microservices.url.product-service}")
    private String productServiceUrl;

    public Order getOrderById(Integer id){
        Optional<Order> op = dao.findById(id);

        if(op.isPresent()) {
            Order order =  op.get();
            RestTemplate rt = new RestTemplate();
            try{
                // visit the customer-service and get customer details
                String url = customerServiceUrl + order.getCustomerId();
                log.debug("Visiting the customer service using the url {}", url);

                Customer customer = rt.getForObject(url, Customer.class);
                order.setCustomer(customer);
            }
            catch(Exception ex){
                log.error("There wan an exception while getting customer details", ex);
            }

            return order;
        }
        throw new RuntimeException("No order found for id " + id);
    }
}
