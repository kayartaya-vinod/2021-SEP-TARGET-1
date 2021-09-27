package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import co.vinod.training.utils.DateUtil;
import co.vinod.training.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MergeOperationDemo {
    public static void main(String[] args) {

        Employee emp = new Employee(6, "AllenSmith",
                DateUtil.toDate("2009-10-12"), 3500.0, "allensmith234@xmpl.com");


        EntityManager em = JpaUtil.createEntityManager();
        em.merge(emp); // executes a SELECT query to check if id "5" exists already or not.
        // if not found, emp --> new managed object
        // if found, emp --> dirty managed object

        // during commit --> SQL INSERT OR UPDATE is fired based on the above

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
    }
}
