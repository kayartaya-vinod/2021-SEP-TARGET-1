package co.vinod.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class ConnectToDatabaseServer {

    @SneakyThrows
    public static void main(String[] args) {

        String url = "jdbc:h2:tcp://localhost/~/target_training_db"; // jdbc:mysql://localhost/target_training_db
        String username = "root";
        String password = "Welcome#123";

        // all the added JDBC implementation dependencies automatically register an object of their respective
        // Driver class with DriverManager.
        log.debug("These JDBC drivers are registered with DriverManager");
        DriverManager.drivers().forEach(d->log.debug("{}", d.getClass().getName()));

        // use the getConnection factory method of DriverManger to get a connection to the db.
        Connection conn = DriverManager.getConnection(url, username, password);

        log.debug("got an object of type {} for the variable conn", conn.getClass().getName());

    }
}
