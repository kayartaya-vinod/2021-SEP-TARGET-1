package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetEmployeeById {
    public static void main(String[] args) {
        Integer id = 23;
        EntityManager em = JpaUtil.createEntityManager();

        Employee emp = em.find(Employee.class, id); // SELECT * FROM EMPLOYEES WHERE ID=?

        if (emp == null) {
            log.debug("No data found for employee id {}", id);
        } else {
            log.debug("emp = {}", emp);
        }

        em.close();
    }
}
