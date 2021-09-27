package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import co.vinod.training.utils.DateUtil;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Slf4j
public class UpdateEmployee {
    public static void main(String[] args) {

        // a transient object (according to hibernate)
        Employee emp1 = new Employee("Allen Smith", 3500.0, "allensmith@xmpl.com");

        EntityManager em = JpaUtil.createEntityManager();
        Employee emp = em.find(Employee.class, 1); // emp is obtained using hibernate; already in persistent state
        log.debug("emp = {}", emp);

        // emp was pristine before the below statement
        emp.setHireDate(DateUtil.toDate("2010-05-21"));
        // emp is dirty after the above statement


        em.persist(emp1); // now emp1 is called a persistent object (according to hibernate)

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        tx.commit(); // SQL UPDATE for every dirty objects in the "em" will be fired to the DB.

        em.close();
    }
}
