package co.vinod.training.controllers;

import co.vinod.training.dao.CustomerDao;
import co.vinod.training.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerDao dao;

    @GetMapping(produces = "application/json")
    public Iterable<Customer> handleGetAllCustomers() {
        return dao.findAll();
    }

    @GetMapping(path = "/{customerId}", produces = {"application/json"})
    public Customer handleGetOneCustomer(@PathVariable String customerId) {
        Optional<Customer> op = dao.findById(customerId);
        if (op.isPresent()) {
            return op.get();
        }
        throw new CustomerNotFoundException("No customer found for id " + customerId);
    }
}
