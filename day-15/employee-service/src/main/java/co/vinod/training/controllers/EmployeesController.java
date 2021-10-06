package co.vinod.training.controllers;

import co.vinod.training.dao.EmployeeDao;
import co.vinod.training.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    EmployeeDao dao;

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public Employee handleGetOneEmployee(@PathVariable Integer id) {
        Optional<Employee> op = dao.findById(id);
        if (op.isPresent()) {
            return op.get();
        }

        throw new EmployeeNotFoundException("No employee found with id: " + id);
    }

    @GetMapping(produces = {"application/json"})
    public Iterable<Employee> handleGetAllEmployees() {
        return dao.findAll();
    }

    @GetMapping(path = "/{id}/photo", produces = "image/jpeg")
    public byte[] handleGetOneEmployeePhoto(@PathVariable Integer id) {
        Optional<Employee> op = dao.findById(id);
        if (op.isPresent()) {
            return op.get().getPhoto();
        }

        throw new EmployeeNotFoundException("No employee found with id: " + id);
    }

    @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
    public Employee handleAddNewEmployee(@RequestBody Employee employee) {
        employee.setEmployeeId(null);
        return dao.save(employee);
    }
}
