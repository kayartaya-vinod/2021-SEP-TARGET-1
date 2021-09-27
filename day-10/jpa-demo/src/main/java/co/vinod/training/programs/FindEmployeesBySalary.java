package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class FindEmployeesBySalary {
    public static void main(String[] args) {
        String jpql = "from Employee where salary > ?0";
        EntityManager em = JpaUtil.createEntityManager();
        TypedQuery<Employee> qry = em.createQuery(jpql, Employee.class);
        qry.setParameter(0, 4975.0);
        List<Employee> list = qry.getResultList();

        for(Employee e: list){
            log.debug("Name = {}, Salary = {}", e.getName(), e.getSalary());
        }
    }
}
