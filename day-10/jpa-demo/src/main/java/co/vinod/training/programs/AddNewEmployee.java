package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

@Slf4j
public class AddNewEmployee {
    public static void main(String[] args) {

        Employee emp1 = new Employee("John Doe",  3500.0, "johndoe@xmpl.com");

        // Persistence.createEntityManagerFactory() is a factory method to read persistence.xml
        // and create an instance of some class provided by the Persistence provider
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");
        log.debug("emf is an instance of {}", emf.getClass().getName());
        EntityManager em = emf.createEntityManager();
        log.debug("em is an instance of {}", em.getClass().getName());

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            em.persist(emp1);
            tx.commit(); // SQL INSERT/UPDATE/DELETE is executed at this time for each of the objects in "em"
            log.debug("Employee data saved {}", emp1);
        } catch (Exception e) {
            tx.rollback();
            log.error("Couldn't save employee data", e);
        }
        em.close();
        emf.close();


    }
}
// docker exec -it mysql8server mysql -uroot -pWelcome#123 target_training_db